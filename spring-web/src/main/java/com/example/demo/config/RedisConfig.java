package com.example.demo.config;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * @author yangxvhao
 * @date 2018-10-21 下午12:00.
 */
@Configuration
public class RedisConfig {
    @Bean
    JedisConnectionFactory jedisConnectionFactory() {
        return new JedisConnectionFactory();
    }

    @Bean
    RedisTemplate< String, Object > redisTemplate() {
        final RedisTemplate< String, Object > template =  new RedisTemplate<>();
        template.setConnectionFactory( jedisConnectionFactory() );
        template.setKeySerializer( new StringRedisSerializer() );
        template.setHashValueSerializer( new GenericFastJsonRedisSerializer() );
        template.setValueSerializer( new GenericFastJsonRedisSerializer() );
        return template;
    }
}
