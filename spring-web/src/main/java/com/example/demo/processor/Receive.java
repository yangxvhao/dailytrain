package com.example.demo.processor;

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
public abstract class Receive {
    public Object receive(Object message){
        log.info("receive:{}", message);
        return process(message);
    }
    
    public abstract Object process(Object message);
}
