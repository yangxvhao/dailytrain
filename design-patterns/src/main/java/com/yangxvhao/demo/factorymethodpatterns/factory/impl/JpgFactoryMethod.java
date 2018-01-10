package com.yangxvhao.demo.factorymethodpatterns.factory.impl;

import com.yangxvhao.demo.factorymethodpatterns.factory.FactoryMethod;
import com.yangxvhao.demo.factorymethodpatterns.product.PictureReader;
import com.yangxvhao.demo.factorymethodpatterns.product.impl.JpgPictureReader;

/**
 * 具体产品类
 * @author yangxvhao
 * @date 18-1-9.
 */

public class JpgFactoryMethod implements FactoryMethod {
    @Override
    public PictureReader create() {
        return new JpgPictureReader();
    }

    @Override
    public PictureReader create(String str) {
        return null;
    }
}
