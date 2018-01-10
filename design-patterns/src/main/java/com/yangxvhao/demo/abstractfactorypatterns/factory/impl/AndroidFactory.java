package com.yangxvhao.demo.abstractfactorypatterns.factory.impl;

import com.yangxvhao.demo.abstractfactorypatterns.factory.OperatingSystemFactory;
import com.yangxvhao.demo.abstractfactorypatterns.product.InterfaceController;
import com.yangxvhao.demo.abstractfactorypatterns.product.OperationController;
import com.yangxvhao.demo.abstractfactorypatterns.product.impl.AndroidInterfaceController;
import com.yangxvhao.demo.abstractfactorypatterns.product.impl.AndroidOperationController;

/**
 * 具体工厂类,
 * @author yangxvhao
 * @date 18-1-9.
 */

public class AndroidFactory implements OperatingSystemFactory {

    @Override
    public OperationController createOc() {
        return new AndroidOperationController();
    }

    @Override
    public InterfaceController createIc() {
        return new AndroidInterfaceController();
    }
}
