package com.yangxvhao.demo.proxy.createpattern.factorymethodpatterns.factory.impl;

import com.yangxvhao.demo.proxy.createpattern.factorymethodpatterns.product.impl.JpgPictureReader;
import com.yangxvhao.demo.proxy.createpattern.factorymethodpatterns.product.PictureReader;
import com.yangxvhao.demo.proxy.createpattern.factorymethodpatterns.factory.AbstractFactoryMethod;

/**
 * @author yangxvhao
 * @date 18-1-9.
 */

public class JpgAbstractFactoryMethod extends AbstractFactoryMethod {
    @Override
    public PictureReader create() {
        return new JpgPictureReader();
    }
}
