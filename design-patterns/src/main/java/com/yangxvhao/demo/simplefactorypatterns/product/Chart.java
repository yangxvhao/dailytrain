package com.yangxvhao.demo.simplefactorypatterns.product;

/**
 * 抽象产品类
 * 有时候，为了简化简单工厂模式，我们可以将抽象产品类和工厂类合并，将静态工厂方法移至抽象产品类中
 * 客户端可以通过产品父类的静态工厂方法，根据参数的不同创建不同类型的产品子类对象，这种做法在JDK等类库和框架中也广泛存在。
 * @author yangxvhao
 * @date 18-1-8.
 */

public interface Chart {
    public void displsy();
}
