package com.yangxvhao.demo.createpattern.factorymethodpatterns.factory;

import com.yangxvhao.demo.createpattern.factorymethodpatterns.product.PictureReader;

/**
 * 抽象工厂方法,
 * 隐藏工厂方法,在工厂类中直接调用产品类的业务方法
 * @author yangxvhao
 * @date 18-1-9.
 */

public abstract class AbstractFactoryMethod {
    public void reader(){
        this.create().reader();
    }

    public abstract PictureReader create();

}
