package com.yangxvhao.demo.proxy.createpattern.factorymethodpatterns.factory.impl;

import com.yangxvhao.demo.proxy.createpattern.factorymethodpatterns.product.impl.GifPictureReader;
import com.yangxvhao.demo.proxy.createpattern.factorymethodpatterns.product.PictureReader;
import com.yangxvhao.demo.proxy.createpattern.factorymethodpatterns.factory.AbstractFactoryMethod;

/**
 * @author yangxvhao
 * @date 18-1-9.
 */

public class GifAbstractFactoryMethod extends AbstractFactoryMethod {
    @Override
    public PictureReader create() {
        return new GifPictureReader();
    }
}
