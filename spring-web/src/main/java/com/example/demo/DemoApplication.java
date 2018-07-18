package com.example.demo;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication()
@EnableAutoConfiguration(exclude={DataSourceAutoConfiguration.class})
@RestController("/")
@Slf4j
public class DemoApplication {
    
//    @Autowired
//    RedisTemplate redisTemplate; 

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
