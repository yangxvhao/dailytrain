package com.example.demo.dto;

import com.example.demo.valid.Second;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotNull;

/**
 * @author yangxvhao
 * @date 18-6-19.
 */
@Data
@ToString
public class Job {
    @NotNull(groups = Second.class, message = "职业第一名称不能为空")
    private String firstName;

    private String secondName;
}
