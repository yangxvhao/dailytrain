package com.example.demo.controller;

import com.example.demo.annotation.ParamA;
import com.example.demo.dto.User;
import com.example.demo.valid.Group;
import com.example.demo.valid.Second;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
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
    
    @GetMapping("get/{id}")
    public String getParam(@ParamA String id){
        return "id:" + id;
    }
    
    @PostMapping("user")
    @ResponseBody
    public String getUser(@ParamA User user, Model model){
        log.info(user.toString());
        log.info("model:{}", model);
        return user.toString();
    }

    @PostMapping("user/job")
    @ResponseBody
    public String getUserAndJob(@ModelAttribute User user, Model model){
        log.info(user.toString());
        log.info("model:{}", model);
        return user.toString();
    }
}
