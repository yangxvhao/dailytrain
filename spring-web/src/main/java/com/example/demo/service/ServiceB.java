package com.example.demo.service;

import com.example.demo.annotation.MyScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author yangxuhao
 * @date 2019-12-06 18:14.
 */
@Component

public class ServiceB {
//    @Autowired
//    ServiceA serviceA;

    @Autowired
    public ServiceB() {

    }

  public void print(){
    System.out.println("bbbbbb");
  }
}
