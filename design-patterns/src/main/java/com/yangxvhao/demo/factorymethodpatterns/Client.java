package com.yangxvhao.demo.factorymethodpatterns;

/**
 * 客户端可以通过配置文件来实现用哪个工厂,生产什么产品
 * @author yangxvhao
 * @date 18-1-9.
 */

public class Client {
    public static void main(String[] args) {
        FactoryMethod factory = new GifFactoryMethod();
        factory.create().reader();
//
//        AbstractFactoryMethod abstractFactoryMethod = new GifAbstractFactory();
//        abstractFactoryMethod.reader();
    }
}
