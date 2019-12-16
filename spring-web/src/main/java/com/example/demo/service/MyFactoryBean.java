package com.example.demo.service;

import org.springframework.beans.factory.FactoryBean;

/**
 * @author yangx
 * @date 2019-12-15 15:54.
 */
public class MyFactoryBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new ServiceB();
    }

    @Override
    public Class<?> getObjectType() {
        return ServiceB.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
