package com.yangxvhao.demo.proxy.createpattern.factorymethodpatterns.product.impl;

import com.yangxvhao.demo.proxy.createpattern.factorymethodpatterns.product.PictureReader;

/**
 * 具体产品类
 * @author yangxvhao
 * @date 18-1-9.
 */

public class GifPictureReader implements PictureReader {
    @Override
    public void reader() {
        System.out.println("reader gif picture");
    }
}
