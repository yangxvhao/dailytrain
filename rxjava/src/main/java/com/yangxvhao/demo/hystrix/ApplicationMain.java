package com.yangxvhao.demo.hystrix;

import com.yangxvhao.demo.hystrix.command.HelloWorldCommand;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

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
