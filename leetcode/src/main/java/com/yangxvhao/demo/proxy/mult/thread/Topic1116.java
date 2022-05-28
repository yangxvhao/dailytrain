package com.yangxvhao.demo.proxy.mult.thread;

import lombok.Getter;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.function.IntConsumer;

/**
 * @author yangxuhao
 * @date 2019-11-08 15:14.
 */
public class Topic1116 {
    @Getter
    private int n;
    private Semaphore semaphore0;
    private Semaphore semaphore1;
    private Semaphore semaphore2;

    public Topic1116(int n) {
        this.n = n;
        this.semaphore0 = new Semaphore(1);
        this.semaphore1 = new Semaphore(0);
        this.semaphore2 = new Semaphore(0);
    }

    // printNumber.accept(x) outputs "x", where x is an integer.
    public void zero(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i++) {
            semaphore0.acquire();
            printNumber.accept(0);
            if (i % 2 == 0) {
                semaphore2.release();
            } else {
                semaphore1.release();
            }
        }

    }

    public void even(IntConsumer printNumber) throws InterruptedException {
        for (int i = 2; i <= n; i += 2) {
            semaphore2.acquire();
            printNumber.accept(i);
            semaphore0.release();
        }
    }

    public void odd(IntConsumer printNumber) throws InterruptedException {
        for (int i = 1; i <= n; i += 2) {
            semaphore1.acquire();
            printNumber.accept(i);
            semaphore0.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Topic1116 topic1116 = new Topic1116(20);
        StringBuffer stringBuffer = new StringBuffer();
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        executorService.execute(() -> {
            try {
                topic1116.zero(stringBuffer::append);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.execute(() -> {
            try {
                topic1116.even(stringBuffer::append);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.execute(() -> {
            try {
                topic1116.odd(stringBuffer::append);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        executorService.awaitTermination(1000, TimeUnit.MILLISECONDS);
        System.out.println(stringBuffer.toString());
        executorService.shutdown();
    }
}
