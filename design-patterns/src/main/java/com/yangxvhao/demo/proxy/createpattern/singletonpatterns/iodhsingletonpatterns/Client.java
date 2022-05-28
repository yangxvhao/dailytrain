package com.yangxvhao.demo.proxy.createpattern.singletonpatterns.iodhsingletonpatterns;

/**
 * @author yangxvhao
 * @date 18-1-10.
 */

public class Client {
    public static void main(String[] args) {

        LoadBalance loadBalance, loadBalance1;
        loadBalance = LoadBalance.getInstance();
        loadBalance1 = LoadBalance.getInstance();
        System.out.println(loadBalance == loadBalance1);
    }
}
