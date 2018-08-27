package com.example.demo.util;

import com.example.demo.dto.User;
import com.sun.javafx.collections.MappingChange;
import lombok.extern.slf4j.Slf4j;
import org.springframework.ui.Model;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.json.MappingJackson2JsonView;

import java.util.HashMap;
import java.util.Map;

/**
 * 全局错误处理
 * 1、通过@ControllerAdvice注解可以将对于控制器的全局配置放在同一个位置。 
 * 2、注解了@Controller的类的方法可以使用@ExceptionHandler、@InitBinder、@ModelAttribute注解到方法上。 
 * 3、@ControllerAdvice注解将作用在所有注解了@RequestMapping的控制器的方法上。 
 * 4、@ExceptionHandler：用于全局处理控制器里的异常。 
 * 5、@InitBinder：用来设置WebDataBinder，用于自动绑定前台请求参数到Model中。 
 * 6、@ModelAttribute：本来作用是绑定键值对到Model中，此处让全局的@RequestMapping都能获得在此处设置的键值对 
 * @author yangxvhao
 * @date 18-6-19.
 */
@ControllerAdvice
@Slf4j
public class GlobalController {
    /**
     * 应用到所有@RequestMapping注解的方法，在其抛出异常时执行
     * 拦截对应异常，并做处理
     * @param e
     * @return
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ModelAndView argError(MethodArgumentNotValidException e) {
        e.printStackTrace();
        log.error("参数解析错误:{}", e.getMessage());
        HashMap map = new HashMap();
        e.getBindingResult().getAllErrors().forEach(objectError -> map.put(objectError.getCode() ,objectError.getDefaultMessage()));
        return new ModelAndView(new MappingJackson2JsonView(), map);
    }
    
    @ExceptionHandler(Exception.class)
    public ModelAndView error(Exception e){
        e.printStackTrace();
        HashMap map = new HashMap(){{
            put("error", e.getLocalizedMessage());
        }};
        return new ModelAndView(new MappingJackson2JsonView(), map);
    }

    /**
     * 应用到所有@RequestMapping注解方法  
     * 此处将键值对添加到全局，注解了@RequestMapping的方法都可以获得此键值对
     * 可以改变User对象的值
     * @param model
     * @param user
     */
    @ModelAttribute
    public void addUser(Model model, User user){
        model.addAttribute("msg", "全局值");
        user.setName("拦截修改");
        user.setAge(0);
    }
}
