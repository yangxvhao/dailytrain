package com.example.demo.config;

import com.rabbitmq.client.AMQP;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.amqp.RabbitProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author yangxvhao
 * @date 18-7-10.
 */

/**
 * @ConfigurationProperties注解主要用来把properties配置文件转化为bean来使用的，
 * 而@EnableConfigurationProperties注解的作用是@ConfigurationProperties注解生效。
 */
@Configuration
@EnableConfigurationProperties({RabbitProperties.class, DemoProperties.class})
public class RabbitConfig {
    
    @Autowired
    RabbitProperties properties;
    
    @Autowired
    DemoProperties demoProperties;
    
    @Bean(name = "connectionFactory")
    public ConnectionFactory getCachingConnectionFactory(){
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        connectionFactory.setHost(properties.getHost());
        connectionFactory.setPort(properties.getPort());
        connectionFactory.setUsername(properties.getUsername());
        connectionFactory.setPassword(properties.getPassword());
        connectionFactory.setVirtualHost(properties.getVirtualHost());
        return connectionFactory;
    }
    
    @Bean(name = "rabbitAdmin")
    public RabbitAdmin getRabbitAdmin(){
        RabbitAdmin rabbitAdmin = new RabbitAdmin(getCachingConnectionFactory());
        rabbitAdmin.setAutoStartup(true);
        return rabbitAdmin;
    }
    
    
}
