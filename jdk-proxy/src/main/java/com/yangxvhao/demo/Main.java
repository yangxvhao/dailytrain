package com.yangxvhao.demo;

import java.lang.reflect.Proxy;

/**
 * @author yangxvhao
 * @date 2018-11-02 下午4:44.
 */
public class Main {
    public static void main(String[] args) {
        //静态代理
//        ProxyHello proxyHello = new ProxyHello(new HelloImpl("tom"));
//        proxyHello.show("how are you!");
        
        //jdk-proxy
        Hello hello = new HelloImpl("tom");
        Hello proxy = (Hello) Proxy.newProxyInstance(hello.getClass().getClassLoader(), new Class[]{Hello.class}, new HelloHandler(hello));
        proxy.show("world");
    }
}
