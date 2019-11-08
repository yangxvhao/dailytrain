package com.yangxvhao.demo.mult.thread;

import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * @author yangxuhao
 * @date 2019-11-08 19:25.
 */
public class Topic1117 {
    //H
    private Semaphore semaphore1;
    //O
    private Semaphore semaphore2;

    public Topic1117() {
        this.semaphore1 = new Semaphore(2);
        this.semaphore2 = new Semaphore(1);
    }

    public void hydrogen(Runnable releaseHydrogen) throws InterruptedException {
        semaphore1.acquire();
        // releaseHydrogen.run() outputs "H". Do not change or remove this line.
        releaseHydrogen.run();
        if(semaphore2.availablePermits() == 0){
            semaphore1.release(2);
        }
    }

    public void oxygen(Runnable releaseOxygen) throws InterruptedException {
        semaphore2.acquire();
        // releaseOxygen.run() outputs "O". Do not change or remove this line.
        releaseOxygen.run();
        if(semaphore1.availablePermits() == 0){
            semaphore2.release();
        }
    }

    public static void main(String[] args) throws InterruptedException {
        Topic1117 topic1117 = new Topic1117();
        topic1117.hydrogen(() -> {});
    }
}
