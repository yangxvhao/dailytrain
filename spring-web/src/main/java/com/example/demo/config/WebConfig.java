package com.example.demo.config;

import com.example.demo.annotation.ArgumentResolver;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * 需要把自定义的解析器（Resolvers）添加进Spring的解析链中
 * WebMvcConfigurerAdapter中还能添加自定义的消息转换器等都需要在这里配置
 * @author yangxvhao
 * @date 18-6-27.
 */
//@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
//        argumentResolvers.clear();
        argumentResolvers.add(new ArgumentResolver());
//        super.addArgumentResolvers(new ArrayList<HandlerMethodArgumentResolver>(){{
//            add(new ArgumentResolver());
//        }});
    }
}
