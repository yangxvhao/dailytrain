package com.example.demo.controller;

import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author yangxvhao
 * @date 18-6-29.
 */
@RestController
@RequestMapping("/rabbit")
public class ControllerB {
    
    @Autowired
    RabbitTemplate rabbitTemplate;
    
    @PostMapping("/send")
    public String sendAndReceive(@RequestBody String message){
        Message message1 = new Message(message.getBytes(), new MessageProperties());
        Message result = rabbitTemplate.sendAndReceive("quote", "100000.0.0.0.0.0.0.0.1.", message1);
        return "received:" + new String(result.getBody()) + "";
    }
}
