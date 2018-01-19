package com.yangxvhao.demo.createpattern.singletonpatterns.iodhsingletonpatterns;

/**
 * 饿汉式单例类不能实现延迟加载，不管将来用不用始终占据内存；
 * 懒汉式单例类线程安全控制烦琐，而且性能受影响。
 * Initialization Demand Holder 将两者的优点合二为一
 * @author yangxvhao
 * @date 18-1-10.
 */

public class LoadBalance {
    private LoadBalance(){}

    /**
     * 由于静态单例对象没有作为Singleton的成员变量直接实例化，
     * 因此类加载时不会实例化Singleton，第一次调用getInstance()时将加载内部类HolderClass，
     * 在该内部类中定义了一个static类型的变量instance，
     * 此时会首先初始化这个成员变量，由Java虚拟机来保证其线程安全性，
     * 确保该成员变量只能初始化一次。
     */
    private static class InstanceHelper{
        private static final LoadBalance instance = new LoadBalance();
    }

    public static LoadBalance getInstance(){
        return InstanceHelper.instance;
    }

}
