package com.example.demo.annotation;

import java.lang.annotation.*;

/**
 * @author yangxvhao
 * @date 18-6-27.
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ParamA {
}
