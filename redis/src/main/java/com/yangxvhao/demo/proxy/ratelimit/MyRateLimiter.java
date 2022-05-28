package com.yangxvhao.demo.proxy.ratelimit;

import com.google.common.util.concurrent.RateLimiter;

import java.util.Calendar;
import java.util.concurrent.*;

/**
 * @author yangxuhao
 * @date 2019-02-27 18:33.
 */
public class MyRateLimiter {
    final static RateLimiter rateLimiter = RateLimiter.create(0.5);

    public static void main(String[] args) {
        ExecutorService executorService = new ThreadPoolExecutor(10, 20, 10, TimeUnit.SECONDS, new LinkedBlockingDeque<Runnable>());
        for (int i = 0; i < 10; i++) {
            int finalI = i;
            int milliSecond = Calendar.getInstance().get(Calendar.SECOND);
            rateLimiter.acquire();
            executorService.execute(() -> System.out.println(milliSecond + "---" + finalI));
        }
        while (true){
            System.out.println("------true---");
            if(!executorService.isTerminated()){
                executorService.shutdown();
                return;
            }
        }
    }
}
