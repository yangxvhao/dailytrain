package com.yangxvhao.demo.createpattern.singletonpatterns.lazysingletonpatterns;

/**
 * @author yangxvhao
 * @date 18-1-10.
 */

public class Client {
    public static void main(String[] args) {
        LoadBalancer loadBalancer, loadBalancer1, loadBalancer2;
        loadBalancer = LoadBalancer.getInstance();
        loadBalancer1 = LoadBalancer.getInstance();
        loadBalancer2 = LoadBalancer.getInstance();
        System.out.println(loadBalancer == loadBalancer1);
    }
}
