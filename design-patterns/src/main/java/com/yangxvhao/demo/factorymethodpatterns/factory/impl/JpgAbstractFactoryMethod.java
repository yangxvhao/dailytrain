package com.yangxvhao.demo.factorymethodpatterns.factory.impl;

import com.yangxvhao.demo.factorymethodpatterns.product.impl.JpgPictureReader;
import com.yangxvhao.demo.factorymethodpatterns.product.PictureReader;
import com.yangxvhao.demo.factorymethodpatterns.factory.AbstractFactoryMethod;

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
