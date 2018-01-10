package com.yangxvhao.demo.singletonpatterns.lazysingletonpatterns;

/**
 * 懒汉式单例类
 * @author yangxvhao
 * @date 18-1-10.
 */

public class LoadBalancer {
    /**
     * volatile保证变量线程安全
     */
    private volatile static LoadBalancer instance = null;

    private LoadBalancer(){}

    /**
     * 双重锁判断,防止多线程产生多个实例
     * @return
     */
    public static LoadBalancer getInstance() {
        if(instance == null){
            synchronized (LoadBalancer.class) {
                if(instance == null) {
                    instance = new LoadBalancer();
                }
            }
        }
        return instance;
    }
}
