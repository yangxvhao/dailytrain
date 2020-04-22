package com.example.demo.service;

import com.example.demo.util.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * @author yangxuhao
 * @date 2019-12-06 18:14.
 */
@Component
public class ServiceA {
    @Autowired
    private ServiceB serviceB;

    @PostConstruct
    public void init(){
        System.out.println("------------------------init" + serviceB);
    }

    @PreDestroy
    public void destroy(){
        System.out.println("----------------------------destroy");
    }

    public ServiceA() {
        System.out.println("---------------------ServiceA()");
    }

    public void setServiceB(ServiceB serviceB) {
        System.out.println("--------------------setServiceB");
        this.serviceB = serviceB;
    }

    public void testAop(){
        ServiceA serviceA = SpringUtils.getBean(ServiceA.class);
        testAopInner(serviceA);
    }

    public void testAopInner(ServiceA serviceA ){
        serviceA.display();
    }

    public void display(){
        serviceB.print();
    }

    //    @Autowired
//    public ServiceA(ServiceB serviceB) {
//        this.serviceB = serviceB;
//    }
}
