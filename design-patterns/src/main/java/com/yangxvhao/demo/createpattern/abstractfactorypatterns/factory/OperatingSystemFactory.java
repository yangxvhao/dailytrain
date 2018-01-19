package com.yangxvhao.demo.createpattern.abstractfactorypatterns.factory;

import com.yangxvhao.demo.createpattern.abstractfactorypatterns.product.InterfaceController;
import com.yangxvhao.demo.createpattern.abstractfactorypatterns.product.OperationController;

/**
 * 抽象工厂类
 * 跟工厂方法类似,也可以在抽象共产里定义多个重载的工厂方法,提供不同的创建方式
 * @author yangxvhao
 * @date 18-1-9.
 */

public interface OperatingSystemFactory {
    OperationController createOc();
    InterfaceController createIc();
}
