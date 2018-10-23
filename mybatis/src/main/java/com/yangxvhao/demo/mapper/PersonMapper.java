package com.yangxvhao.demo.mapper;

import com.yangxvhao.demo.model.Person;

import java.util.List;

/**
 * @author yangxvhao
 * @date 2018-09-27 下午6:06.
 */
public interface PersonMapper {
    List<Person> selectList();
}
