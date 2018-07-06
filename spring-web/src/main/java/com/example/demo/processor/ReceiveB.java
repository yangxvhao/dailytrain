package com.example.demo.processor;

import lombok.extern.slf4j.Slf4j;

import static jodd.util.ThreadUtil.sleep;

/**
 * @author yangxvhao
 * @date 18-7-6.
 */
@Slf4j
public class ReceiveB extends Receive {
    @Override
    public Object process(Object message) {
        log.info("---BBB---");
        sleep(5 * 1000);
        return "hello " + message + "I am B;";
    }
}
