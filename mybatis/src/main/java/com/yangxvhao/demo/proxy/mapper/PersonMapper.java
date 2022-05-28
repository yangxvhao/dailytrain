package com.yangxvhao.demo.proxy.mapper;

import com.yangxvhao.demo.proxy.model.Person;

import java.util.List;

/**
 * @author yangxvhao
 * @date 2018-09-27 下午6:06.
 */
public interface PersonMapper {
    List<Person> selectList();
    List<Person> selectList(String name);
}
