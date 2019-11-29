package com.yangxvhao.demo.model;

import lombok.Data;

/**
 * @author yangxuhao
 * @date 2019-11-26 12:05.
 */

public class Person {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    private String name;
    private Integer age;

}
