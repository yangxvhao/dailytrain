package com.yangxvhao.demo.factorymethodpatterns.abstractfactory;

import com.yangxvhao.demo.factorymethodpatterns.JpgPictureReader;
import com.yangxvhao.demo.factorymethodpatterns.PictureReader;

/**
 * @author yangxvhao
 * @date 18-1-9.
 */

public class JpgAbstractFac extends AbstractFactoryMethod {
    @Override
    public PictureReader create() {
        return new JpgPictureReader();
    }
}
