package com.example.demo.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.stereotype.Component;

import static jodd.util.ThreadUtil.sleep;

/**
 * @author yangxvhao
 * @date 18-6-29.
 */
@Slf4j
@Component
public class Receive {
    public Object receive(Object message){
        String messages = String.valueOf(message);
        log.info("receive:{}", messages);
        sleep(6 * 1000);
        return "hello " + messages;
    }
}
