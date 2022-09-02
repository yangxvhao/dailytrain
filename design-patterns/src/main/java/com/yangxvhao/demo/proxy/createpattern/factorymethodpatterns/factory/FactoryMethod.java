package com.yangxvhao.demo.proxy.createpattern.factorymethodpatterns.factory;

import com.yangxvhao.demo.proxy.createpattern.factorymethodpatterns.product.PictureReader;

/**
 * 抽象工厂
 *
 * 重载方法:在抽象工厂中定义多个重载的工厂方法，在具体工厂中实现了这些工厂方法，
 * 这些方法可以包含不同的业务逻辑，以满足对不同产品对象的需求。
 *
 * 隐藏工厂方法,简化客户端调用:有时候，为了进一步简化客户端的使用，还可以对客户端隐藏工厂方法，
 * 此时，在工厂类中将直接调用产品类的业务方法，客户端无须调用工厂方法创建产品，
 * 直接通过工厂即可使用所创建的对象中的业务方法。
 * @author yangxvhao
 * @date 18-1-9.
 */

public interface FactoryMethod {
   PictureReader create();

   /**
    * 重载的工厂方法
    * @param str
    * @return
    */
   PictureReader create(String str);
}
