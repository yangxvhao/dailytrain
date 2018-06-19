package com.example.demo;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/**
 * @author yangxvhao
 * @date 18-6-19.
 */
@ControllerAdvice
public class GlobalController {
    @ExceptionHandler(Exception.class)
    public String error(Exception e){
        return e.getMessage();
    }
}
