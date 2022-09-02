package com.yangxvhao.demo.proxy;

/**
 * 为什么要用代理
 * 在执行真是对象方法之前，之后想要做一些事情
 * 用到了代理模式
 * @author yangxvhao
 * @date 2018-11-02 下午5:16.
 */
public class ProxyHello {
    private HelloImpl hello;

    public ProxyHello(HelloImpl hello) {
        this.hello = hello;
    }
    
    public void show(String message){
        /**
         * 静态代理，代码侵入，重复
         */
        System.out.println("前置处理...");
        
        //真正要执行的方法
        hello.show(message);
        
        System.out.println("后置处理");
    }
}
