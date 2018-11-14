package com.yangxvhao.demo.createpattern.singletonpatterns.enumsingletonpatterns;

import com.yangxvhao.demo.createpattern.singletonpatterns.iodhsingletonpatterns.LoadBalance;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * @author yangxvhao
 * @date 2018-11-12 下午12:01.
 */
@Slf4j
public class Client {
    public static void main(String[] args) {
        ExecutorService service = new ThreadPoolExecutor(8,8,1, TimeUnit.MINUTES, new ArrayBlockingQueue<>(10));
        for (int i = 0; i < 19; i++) {
            service.execute(() -> {
//                log.info(Singleton.INSTANCE.getInstance().toString());
                log.info(LoadBalance.getInstance().toString());
            });  
        }
        
//        LoadBalancer loadBalancer = Singleton.INSTANCE.getInstance();
//        LoadBalancer loadBalancer1 = Singleton.INSTANCE.getInstance();
//        System.out.println(loadBalancer == loadBalancer1);
    }
}
