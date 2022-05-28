package com.yangxvhao.demo.proxy.mult.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author yangxuhao
 * @date 2019-09-30 16:24.
 */
public class Topic1115 {
    private int n;
    private Semaphore semaphore;
    private Semaphore semaphore1;

    public Topic1115(int n) {
        this.n = n;
        semaphore = new Semaphore(1);
        semaphore1 = new Semaphore(0);
    }

    public void foo(Runnable printFoo) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphore.acquire();
            // printFoo.run() outputs "foo". Do not change or remove this line.
            printFoo.run();
            semaphore1.release();
        }
    }

    public void bar(Runnable printBar) throws InterruptedException {

        for (int i = 0; i < n; i++) {
            semaphore1.acquire();
            // printBar.run() outputs "bar". Do not change or remove this line.
            printBar.run();
            semaphore.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Topic1115 topic1115 = new Topic1115(100);
        ExecutorService executors = Executors.newFixedThreadPool(2);
        executors.execute(() -> {
            try {
                topic1115.bar(() -> {
                    System.out.println("bar");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        executors.execute(() -> {
            try {
                topic1115.foo(() -> {
                    System.out.println("foo");
                });
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

    }
}
