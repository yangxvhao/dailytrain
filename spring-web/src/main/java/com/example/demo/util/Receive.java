package com.example.demo.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.stereotype.Component;

/**
 * @author yangxvhao
 * @date 18-6-29.
 */
@Slf4j
@Component
public class Receive {
    public Message handleMessage(byte[] message){
        log.info("receive:{}", new String(message));
        return new Message("hello".getBytes(), new MessageProperties());
    }
}
