package com.yangxvhao.demo.factorymethodpatterns.factory.impl;

import com.yangxvhao.demo.factorymethodpatterns.factory.FactoryMethod;
import com.yangxvhao.demo.factorymethodpatterns.product.PictureReader;
import com.yangxvhao.demo.factorymethodpatterns.product.impl.GifPictureReader;

/**
 * 具体工厂类
 * @author yangxvhao
 * @date 18-1-9.
 */

public class GifFactoryMethod implements FactoryMethod {
    @Override
    public PictureReader create() {
        return new GifPictureReader();
    }

    @Override
    public PictureReader create(String str) {
        return null;
    }
}
