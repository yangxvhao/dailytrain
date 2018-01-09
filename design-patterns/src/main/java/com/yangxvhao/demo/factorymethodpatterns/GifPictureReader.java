package com.yangxvhao.demo.factorymethodpatterns;

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
