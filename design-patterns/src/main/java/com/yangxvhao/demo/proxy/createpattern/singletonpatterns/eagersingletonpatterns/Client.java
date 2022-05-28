package com.yangxvhao.demo.proxy.createpattern.singletonpatterns.eagersingletonpatterns;

/**
 * @author yangxvhao
 * @date 18-1-10.
 */

public class Client {
    public static void main(String[] args) {
        LoadBalancer loadBalancer1, loadBalancer2, loadBalancer3;
        loadBalancer1 = LoadBalancer.getInstance();
        loadBalancer2 = LoadBalancer.getInstance();
        loadBalancer3 = LoadBalancer.getInstance();
        loadBalancer1.addService("1111111");
        loadBalancer2.addService("2222222");
        System.out.println(loadBalancer3.getService());
        System.out.println(loadBalancer1 == loadBalancer2);
    }
}
