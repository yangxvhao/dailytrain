package com.yangxvhao.demo.proxy.mult.thread;

import lombok.Data;

import java.util.concurrent.CountDownLatch;

/**
 * @author yangxuhao
 * @date 2019-09-30 15:51.
 */
class Topic1114 {
    private CountDownLatch second = new CountDownLatch(1);
    private CountDownLatch third = new CountDownLatch(1);
    public CountDownLatch getSecond(){
        return second;
    }
    public CountDownLatch getThird(){
        return third;
    }
    public Topic1114() {

    }

    public void first(Runnable printFirst) throws InterruptedException {
        // printFirst.run() outputs "first". Do not change or remove this line.
        printFirst.run();
        getSecond().countDown();
    }

    public void second(Runnable printSecond) throws InterruptedException {
        try {
            getSecond().await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // printSecond.run() outputs "second". Do not change or remove this line.
        printSecond.run();
        getThird().countDown();
    }

    public void third(Runnable printThird) throws InterruptedException {
        try {
            getThird().await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        // printThird.run() outputs "third". Do not change or remove this line.
        printThird.run();
    }
}
