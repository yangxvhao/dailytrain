package com.yangxvhao.demo.factorymethodpatterns.abstractfactory;

import com.yangxvhao.demo.factorymethodpatterns.GifPictureReader;
import com.yangxvhao.demo.factorymethodpatterns.PictureReader;

/**
 * @author yangxvhao
 * @date 18-1-9.
 */

public class GifAbstractFactory extends AbstractFactoryMethod {
    @Override
    public PictureReader create() {
        return new GifPictureReader();
    }
}
