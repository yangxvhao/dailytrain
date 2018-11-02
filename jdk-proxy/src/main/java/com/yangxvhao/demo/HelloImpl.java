package com.yangxvhao.demo;

/**
 * @author yangxvhao
 * @date 2018-11-02 下午4:41.
 */
public class HelloImpl implements Hello {
    private String name;

    public HelloImpl(String name) {
        this.name = name;
    }

    public void show(String message){
        System.out.println(name + " said: " + message);
    }
}
