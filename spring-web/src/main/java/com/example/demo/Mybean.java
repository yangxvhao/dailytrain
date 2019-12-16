package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author yangxvhao
 * @date 2018-08-27 下午3:14.
 */
//@Component
public class Mybean {
    @Autowired
    public Mybean(){
//        List<String> strings = arguments.getNonOptionArgs();
        System.out.println("-------------------------&&&&&&&&&&&&&-----------------");
        System.out.println();
    }
}
