package com.yangxvhao.demo.proxy.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @author yangxuhao
 * @date 2019-11-26 12:05.
 */

@Data
@AllArgsConstructor
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

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
    }

    private String name;
    private Integer age;
    private Integer id;

    public static void main(String[] args) throws ParseException {
        Map<String, Person> personMap = new HashMap<>();

        Person person1 = new Person("小明", 10);
        Person person2 = new Person("小强", 10);
        Person person3 = new Person("小红", 10);

        personMap.put(person1.getName(), person1);
        personMap.put(person2.getName(), person2);
        personMap.put(person3.getName(), person3);

        String name = "小明";

        personMap.get(name);

        SimpleDateFormat sourceDft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat targetDft = new SimpleDateFormat("MM/dd");
        Date date = sourceDft.parse("");
        targetDft.format(date);
    }

}
