package com.yangxvhao.demo.proxy.createpattern.abstractfactorypatterns.factory.impl;

import com.yangxvhao.demo.proxy.createpattern.abstractfactorypatterns.factory.OperatingSystemFactory;
import com.yangxvhao.demo.proxy.createpattern.abstractfactorypatterns.product.InterfaceController;
import com.yangxvhao.demo.proxy.createpattern.abstractfactorypatterns.product.OperationController;
import com.yangxvhao.demo.proxy.createpattern.abstractfactorypatterns.product.impl.WPInterfaceController;
import com.yangxvhao.demo.proxy.createpattern.abstractfactorypatterns.product.impl.WPOperationController;

/**
 * @author yangxvhao
 * @date 18-1-9.
 */

public class WindowsPhoneFactory implements OperatingSystemFactory{
    @Override
    public OperationController createOc() {
        return new WPOperationController();
    }

    @Override
    public InterfaceController createIc() {
        return new WPInterfaceController();
    }
}
