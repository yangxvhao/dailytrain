package com.yangxvhao.demo.proxy.concurrent;

import java.util.concurrent.Exchanger;

/**
 * 线程间交换数据
 *
 * @author yangx
 * @Date 2019-12-01 18:54.
 */
public class ExchangerDemo {
    public static void main(String[] args) {
        Exchanger exchanger = new Exchanger();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start!!!!!!!!!!");
            try {
                String s = (String) exchanger.exchange("等我");
                System.out.println(Thread.currentThread().getName() + " print" + s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start===========");
            try {
                String s = (String) exchanger.exchange("你");
                System.out.println(Thread.currentThread().getName() + " print" + s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        new Thread(() -> {
            System.out.println(Thread.currentThread().getName() + " start-------------");
            try {
                String s = (String) exchanger.exchange("ta");
                System.out.println(Thread.currentThread().getName() + " print" + s);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        System.out.println("main end!");
    }
}
