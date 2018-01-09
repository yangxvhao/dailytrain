package com.yangxvhao.demo.factorymethodpatterns;

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
}
