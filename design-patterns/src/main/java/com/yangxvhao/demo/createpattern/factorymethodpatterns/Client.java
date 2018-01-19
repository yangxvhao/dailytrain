package com.yangxvhao.demo.createpattern.factorymethodpatterns;

import com.yangxvhao.demo.createpattern.factorymethodpatterns.factory.FactoryMethod;
import com.yangxvhao.demo.createpattern.factorymethodpatterns.factory.impl.GifFactoryMethod;

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
//        AbstractFactoryMethod abstractFactoryMethod = new GifAbstractFactoryMethod();
//        abstractFactoryMethod.reader();
    }
}
