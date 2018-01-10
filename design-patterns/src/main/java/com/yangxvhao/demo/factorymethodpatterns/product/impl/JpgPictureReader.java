package com.yangxvhao.demo.factorymethodpatterns.product.impl;

import com.yangxvhao.demo.factorymethodpatterns.product.PictureReader;

/**
 * 具体产品类
 * @author yangxvhao
 * @date 18-1-9.
 */

public class JpgPictureReader implements PictureReader {
    @Override
    public void reader() {
        System.out.println("reader jpg picture");
    }
}
