package com.yangxvhao.demo.service.impl;

import com.yangxvhao.demo.service.HelloWorldService;
import org.apache.thrift.TException;

public class HelloWorldServiceImpl implements HelloWorldService.Iface {
    @Override
    public void hello(String msg) throws TException {
        System.out.println("-----thrift service receive----- " + msg);
    }
}
