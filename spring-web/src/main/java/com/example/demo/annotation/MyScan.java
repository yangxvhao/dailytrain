package com.example.demo.annotation;

import com.example.demo.service.MyImportBeanDefinition;
import org.springframework.context.annotation.Import;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 * @author yangx
 * @date 2019-12-15 16:14.
 */
@Retention(RetentionPolicy.RUNTIME)
@Import(MyImportBeanDefinition.class)
public @interface MyScan {
}
