package com.example.demo.processor;

import lombok.extern.slf4j.Slf4j;

import static jodd.util.ThreadUtil.sleep;

/**
 * @author yangxvhao
 * @date 18-7-6.
 */
@Slf4j
public class ReceiveA extends Receive{
    @Override
    public Object process(Object message) {
        log.info("---AAA---");
        sleep(3 * 1000);
        return "hello" + message + "I am A;";
    }
}
