package com.example.demo.dto;

import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Max;

/**
 * @author yangxvhao
 * @date 18-6-19.
 */
@Data
@ToString
public class User {
    @NotEmpty
    private String name;
    
    @Max(value = 100, message = "年龄最大不能超过100")
    private Integer age;
    
    private Job job;
    
}
