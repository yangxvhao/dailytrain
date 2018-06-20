package com.example.demo.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sun.javafx.collections.MappingChange;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.HashMap;
import java.util.Map;

/**
 * @author yangxvhao
 * @date 18-6-19.
 */
@ControllerAdvice
@Slf4j
public class GlobalController {
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ModelAndView argError(MethodArgumentNotValidException e) {
        e.printStackTrace();
        log.error("参数解析错误:{}", e.getMessage());
        Map<String, String> map = new HashMap();
        e.getBindingResult().getAllErrors().forEach(objectError -> map.put(objectError.getCode() ,objectError.getDefaultMessage()));
        return new ModelAndView(new MappingJackson2JsonView(), map);
    }
    
    @ExceptionHandler(Exception.class)
    public ModelAndView error(Exception e){
        Map<String, String> map = new HashMap(){{
            put("error", e.getMessage());
        }};
        return new ModelAndView(new MappingJackson2JsonView(), map);
    }
}
