package com.yangxvhao.demo.hystrix.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;

/**
 * @author yangxuhao
 * @date 2019-07-30 21:15.
 */
public class HelloWorldCommand extends HystrixCommand<String> {
    private String name;

    public HelloWorldCommand(String name) {
        super(HystrixCommandGroupKey.Factory.asKey(name));
        this.name = name;
    }

    @Override
    protected String run() throws Exception {
        return "HttpClient " + name + " request!";
    }
}
