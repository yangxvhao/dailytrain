package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.redis.core.StringRedisTemplate;

import java.util.List;

/**
 * @author yangxvhao
 * @date 2018-08-27 下午2:16.
 */
@SpringBootApplication(exclude = DataSourceAutoConfiguration.class)
public class MyApplication implements ApplicationRunner {
    
    @Autowired
    StringRedisTemplate stringRedisTemplate;
    
    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }
    
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
        List<String> args = applicationArguments.getNonOptionArgs();
        System.out.println(args.toString());
    }
}
