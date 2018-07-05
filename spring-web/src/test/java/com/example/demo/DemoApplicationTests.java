package com.example.demo;

import com.example.demo.util.ThreadPool;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

import static jodd.util.ThreadUtil.sleep;

@Slf4j
public class DemoApplicationTests {

    @Test
    public void contextLoads() throws InterruptedException {
        int sum = 200;
        ThreadPool pool = new ThreadPool(20);
        for (int i = 0; i < sum; i++) {
            ThreadPool.PostRequestTask postRequestTask = pool.create("http://127.0.0.1:8999/rabbit/send", i + "");
            pool.execute(postRequestTask);
//            postRequestTask.run();
        }
        pool.shutdown();
        pool.await();
        log.info("sum:{},success:{}", sum, pool.getSuccessCount());
        
    }

}
