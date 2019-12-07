package com.yangxvhao.demo.concurrent;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * volatile只能保证可见性，不能保证原子性，所以不是线程安全
 *
 * @author yangxuhao
 * @date 2019-12-04 10:11.
 */
public class VolatileDemo {
    private static volatile int num;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService service = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {
            service.submit(() -> {
                for (int j = 0; j < 1000; j++) {
                    int cur = num;
                    num = num + 1;
                }
            });
        }
        Thread.sleep(10000);
        System.out.println(num);
    }
}
