package com.yangxvhao.demo.proxy.concurrent;

import com.yangxvhao.demo.proxy.model.Person;

/**
 * @author yangxuhao
 * @date 2019-12-06 20:10.
 */
public class DoEscapeAnalysisDemo {
    public static void main(String[] args) {
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("bean start");
        for (int i = 0; i < 100000; i++) {
            alloc();
        }

        System.out.println("bean end");
        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void alloc(){
        Person person = new Person();
    }
}
