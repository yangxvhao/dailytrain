package com.example.demo.controller;

import com.example.demo.annotation.ParamA;
import com.example.demo.dto.User;
import com.example.demo.valid.Second;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.ui.Model;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @RestController相当于@Response和＠Controller
 * @Response表示返回的就是response，区别于返回视图名称
 * @author yangxvhao
 * @date 18-6-27.
 */
@RestController
@RequestMapping("/a")
@Slf4j
public class ControllerA {
    @Autowired
    RedisTemplate redisTemplate;

    @GetMapping("health")
    @ResponseBody
    public String heath(){
        return "ok";
    }
    
    @GetMapping("get")
    public String getParam(@ParamA User user){
        redisTemplate.opsForList().leftPush("test", user);
        return user.toString();
    }
    
    @PostMapping("user")
    public String getUser( @ParamA User user, Model model){
        log.info(user.toString());
        log.info("model:{}", model);
        return user.toString();
    }

    @PostMapping("user/job")
    public String getUserAndJob(@Validated(Second.class) User user, Model model){
        log.info(user.toString());
        log.info("model:{}", model);
        return user.toString();
    }
}
