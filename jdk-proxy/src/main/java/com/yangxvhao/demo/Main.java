package com.yangxvhao.demo;

import java.lang.reflect.Proxy;

/**
 * @author yangxvhao
 * @date 2018-11-02 下午4:44.
 */
public class Main {
    private static final int _1MB = 1024*1024;
    
    public static void main(String[] args) {
        //静态代理
        ProxyHello proxyHello = new ProxyHello(new HelloImpl("tom"));
        proxyHello.show("how are you!");
        
//        jdk-proxy
        Hello hello = new HelloImpl("tom");
        Hello proxy = (Hello) Proxy.newProxyInstance(hello.getClass().getClassLoader(), new Class[]{Hello.class}, new HelloHandler(hello));
        proxy.show("world");
        
        //jvm内存分配 vm参数：-verbose:gc -Xms20M -Xmx20M -Xmn10M -XX:SurvivorRatio=8
//        byte[] a1, a2, a3, a4, a5, a6;
//        byte a = 127;
//        a1=new byte[2*_1MB];
//        a2=new byte[2*_1MB];
//        a3=new byte[2*_1MB];
//        a4=new byte[4*_1MB];
//        a5=new byte[4*_1MB];
//        a6=new byte[4*_1MB];
//        System.out.println();
    }
}
