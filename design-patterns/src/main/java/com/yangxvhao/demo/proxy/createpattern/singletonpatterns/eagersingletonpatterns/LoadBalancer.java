package com.yangxvhao.demo.proxy.createpattern.singletonpatterns.eagersingletonpatterns;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * 饿汉式单例类
 * @author yangxvhao
 * @date 18-1-10.
 */

public class LoadBalancer {
    /**
     * 静态私有变量,
     * 在类加载时初始化
     */
    private static LoadBalancer instance = new LoadBalancer();

    private List serverList = null;

    /**
     * 私有构造函数,不能在其他地方实例化
     */
    private LoadBalancer(){
        serverList = new ArrayList();
    }

    /**
     * 提供一个共有方法返回实例化对象
     * @return
     */
    public static LoadBalancer getInstance(){
        return instance;
    }

    public void addService(String service){
        serverList.add(service);
    }

    public void delService(String service){
        serverList.remove(service);
    }

    public String getService(){
        Random random = new Random();
        return serverList.get(random.nextInt(serverList.size())).toString();
    }
}
