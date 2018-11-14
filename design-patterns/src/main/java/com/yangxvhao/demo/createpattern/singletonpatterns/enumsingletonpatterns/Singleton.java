package com.yangxvhao.demo.createpattern.singletonpatterns.enumsingletonpatterns;

/**
 * @author yangxvhao
 * @date 2018-11-12 下午12:00.
 */
public enum Singleton {
    INSTANCE;
    private LoadBalancer loadBalancer;

    Singleton() {
        loadBalancer = new LoadBalancer();
    }
    
    public LoadBalancer getInstance(){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return loadBalancer;
    }
}
