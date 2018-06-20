package com.example.demo.dto;

import com.example.demo.valid.First;
import com.example.demo.valid.Second;
import lombok.Data;
import lombok.ToString;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;

/**
 * @author yangxvhao
 * @date 18-6-19.
 */
@Data
@ToString
public class User {
    @NotEmpty
    private String name;
    
    @NotNull(groups = First.class, message = "年龄不能为空")
    @Max(groups = Second.class, value = 100, message = "年龄最大不能超过100")
    private Integer age;
    
    @Valid
    @NotNull(groups = Second.class, message = "职业信息不能为空")
    private Job job;
}
