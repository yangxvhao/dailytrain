package com.example.demo.service;

/**
 * @author yangx
 * @date 2020-06-15 22:45.
 */
public abstract class AbstractClass {
    public void methodA(){
        System.out.println("AbstractClass methodA");
        abstractMethod();
    }

    public abstract void abstractMethod();
}
