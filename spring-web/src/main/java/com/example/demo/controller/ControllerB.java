package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.AsyncRabbitTemplate;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.util.concurrent.ListenableFutureCallback;
import org.springframework.web.bind.annotation.*;

import java.util.concurrent.ExecutionException;

/**
 * @author yangxvhao
 * @date 18-6-29.
 */
@Slf4j
@RestController
@RequestMapping("/rabbit")
public class ControllerB {
    
    @Autowired
    RabbitTemplate rabbitTemplate;
    
    @Autowired
    ApplicationContext context;
//    
//    @Autowired(required = false)
//    AsyncRabbitTemplate asyncRabbitTemplate;
    
    @PostMapping("/send")
    public String sendAndReceive(@RequestBody String message){
        CachingConnectionFactory connectionFactory = context.getBean(CachingConnectionFactory.class);
        AsyncRabbitTemplate asyncRabbitTemplate = new AsyncRabbitTemplate(connectionFactory, "we-chat", "1.00","chat");
        
//        Message message1 = new Message(message.getBytes(), new MessageProperties());
        asyncRabbitTemplate.start();
//        String result = String.valueOf(rabbitTemplate.convertSendAndReceive("we-chat", "1.0000", message));
        AsyncRabbitTemplate.RabbitConverterFuture<Object> result = asyncRabbitTemplate.convertSendAndReceive("we-chat", "1.00", message);
//        Message result = rabbitTemplate.sendAndReceive("we-chat", "100000.0.0.0.0.0.0.0.1.", message1);
        try {
            result.addCallback(new ListenableFutureCallback<Object>() {
                @Override
                public void onFailure(Throwable throwable) {
                    log.error("--error--");
                }

                @Override
                public void onSuccess(Object o) {
                    log.info("--success--");
                }
            });
            return new String(result.get().toString());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        return null;
    }
}
