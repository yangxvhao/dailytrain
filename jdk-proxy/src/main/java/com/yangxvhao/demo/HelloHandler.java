package com.yangxvhao.demo;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author yangxvhao
 * @date 2018-11-02 下午7:56.
 */
public class HelloHandler implements InvocationHandler {
    private Object target;

    public HelloHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("前置处理");
        Object result =  method.invoke(target, args);
        System.out.println("后置处理");
        return result;
    }
}
