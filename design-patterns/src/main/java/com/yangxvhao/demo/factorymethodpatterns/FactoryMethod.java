package com.yangxvhao.demo.factorymethodpatterns;

/**
 * 抽象工厂
 * 有时候，为了进一步简化客户端的使用，还可以对客户端隐藏工厂方法，
 * 此时，在工厂类中将直接调用产品类的业务方法，客户端无须调用工厂方法创建产品，
 * 直接通过工厂即可使用所创建的对象中的业务方法。
 * @author yangxvhao
 * @date 18-1-9.
 */

public interface FactoryMethod {
   PictureReader create();
}
