package com.yangxvhao.demo.model;

import lombok.Data;

/**
 * @author yangxvhao
 * @date 2018-09-27 下午5:49.
 */
@Data
public class Person {
    private String name;
    private Long age;
    private Address address;
}
