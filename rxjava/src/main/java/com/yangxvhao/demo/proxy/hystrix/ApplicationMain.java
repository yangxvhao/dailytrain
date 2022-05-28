package com.yangxvhao.demo.proxy.hystrix;

import com.yangxvhao.demo.proxy.hystrix.command.HelloWorldCommand;

import java.util.concurrent.TimeUnit;

/**
 * @author yangxuhao
 * @date 2019-07-30 21:24.
 */
public class ApplicationMain {
    public static void main(String[] args) throws Exception {
        HelloWorldCommand command = new HelloWorldCommand("www");
//        String result1 = command.execute();
        String result2 = command.queue().get(20, TimeUnit.MILLISECONDS);
//        String result3 = command.observe().toBlocking().first();
//        System.out.println(result1);
        System.out.println(result2);
//        System.out.println(result3);
    }
}
