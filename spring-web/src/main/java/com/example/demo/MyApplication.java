package com.example.demo;

import com.example.demo.annotation.MyScan;
import com.example.demo.service.ServiceA;
import com.example.demo.service.ServiceB;
import com.example.demo.util.SpringUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.core.ApplicationContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @author yangxvhao
 * @date 2018-08-27 下午2:16.
 */
@Slf4j
@MyScan
@EnableTransactionManagement
@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class MyApplication implements ApplicationRunner {
//    @Autowired
//    RedisTemplate redisTemplate;

    @Autowired
    ConfigurableApplicationContext configurableApplicationContext;


    
    public static void main(String[] args) {

        SpringApplication.run(MyApplication.class, args);
        ServiceA serviceA = SpringUtils.getBean(ServiceA.class);
    }
    
    @Override
    public void run(ApplicationArguments applicationArguments) throws Exception {
//        configurableApplicationContext.getBeanFactory().registerSingleton("serviceA", new ServiceA());
        ServiceB serviceB = configurableApplicationContext.getBean(ServiceB.class);
        System.out.println(serviceB);
//        ExecutorService service = Executors.newSingleThreadExecutor();
//        service.execute(() -> {
//            while (true) {
//                String str = redisTemplate.opsForList().leftPop("test", 0, TimeUnit.SECONDS).toString();
//                log.info(str);
//            }
//        });
    }
}
