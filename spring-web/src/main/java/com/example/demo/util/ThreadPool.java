package com.example.demo.util;

import lombok.extern.slf4j.Slf4j;
import okhttp3.*;

import java.io.IOException;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author yangxvhao
 * @date 18-7-5.
 */
@Slf4j
public class ThreadPool {
    private int threadNum;
    
    private ExecutorService executorService;
    
    private AtomicInteger successCount = new AtomicInteger(0);
    
    public ThreadPool(Integer threadNum){
        this.threadNum = threadNum;
        executorService = Executors.newFixedThreadPool(this.threadNum);
    }
    
    public int getSuccessCount(){
        return successCount.get();
    }
    
    public void execute(Runnable runnable){
        log.info("running, threadNum:{}", threadNum);
        executorService.execute(runnable);
    }
    
    public PostRequestTask create(String url, String body){
        return new PostRequestTask(url, body);
    }
    
    public void shutdown(){
        executorService.shutdown();
    }
    
    public void await(){
        try {
            executorService.awaitTermination(30000, TimeUnit.MILLISECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
    public class PostRequestTask implements Runnable{
        private String url;
        
        private String body;
        
        private boolean isSuccess;

        public PostRequestTask(String url, String body) {
            this.url = url;
            this.body = body;
        }
        
        
        
        @Override
        public void run() {
            OkHttpClient client = new OkHttpClient().newBuilder()
                    .connectTimeout(60000 ,TimeUnit.SECONDS)
                    .readTimeout(600000, TimeUnit.SECONDS)
                    .writeTimeout(600000,TimeUnit.SECONDS)
                    .build();
            
            MediaType mediaType = MediaType.parse("application/octet-stream");
            RequestBody requestBody = RequestBody.create(mediaType, body);
            Request request = new Request.Builder()
                    .url(url)
                    .post(requestBody)
                    .build();

            try {
                Response response = client.newCall(request).execute();
                isSuccess = response.isSuccessful();
                if (isSuccess){
                    successCount.incrementAndGet();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
