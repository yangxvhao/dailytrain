package com.yangxvhao.demo.factorymethodpatterns;

/**
 * 具体工厂类
 * @author yangxvhao
 * @date 18-1-9.
 */

public class GifFactoryMethod implements FactoryMethod {
    @Override
    public PictureReader create() {
        return new  GifPictureReader();
    }
}
