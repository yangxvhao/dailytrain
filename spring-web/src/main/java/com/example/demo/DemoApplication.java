package com.example.demo;

import com.example.demo.dto.User;
import com.example.demo.valid.First;
import com.example.demo.valid.Group;
import com.example.demo.valid.Second;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@SpringBootApplication()
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@RestController("/")
@Slf4j
public class DemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }
    
    @PostMapping("user")
    @ResponseBody
    public String getUser(@RequestBody @Validated(Group.class) User user){
        log.info(user.toString());
        return user.toString();
    }

    @PostMapping("user/job")
    @ResponseBody
    public String getUserAndJob(@RequestBody @Validated(Second.class) User user){
        log.info(user.toString());
        return user.toString();
    }
}
