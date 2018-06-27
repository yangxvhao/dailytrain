package com.example.demo;

import com.example.demo.dto.User;
import com.example.demo.valid.First;
import com.example.demo.valid.Group;
import com.example.demo.valid.Second;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.ui.Model;
import org.springframework.util.StopWatch;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@SpringBootApplication()
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@RestController("/")
@Slf4j
public class DemoApplication {
    
    @Autowired
    RedisTemplate redisTemplate; 

    public static void main(String[] args) {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        
        ApplicationContext context = SpringApplication.run(DemoApplication.class, args);
        for (String bean : context.getBeanDefinitionNames()) {
            log.info(bean);
        }
        stopWatch.stop();
        
        log.info("application start cost time:{}ms, bean count:{}", stopWatch.getTotalTimeSeconds(), context.getBeanDefinitionCount());
    }
    
}
