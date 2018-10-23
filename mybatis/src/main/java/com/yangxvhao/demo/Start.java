package com.yangxvhao.demo;

import com.yangxvhao.demo.mapper.PersonMapper;
import com.yangxvhao.demo.model.Person;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.List;

/**
 * @author yangxvhao
 * @date 2018-09-27 下午5:40.
 */
public class Start {
    public static void main(String[] args) throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        SqlSession sqlSession = sqlSessionFactory.openSession();
        List<Person> people = sqlSession.selectList("com.yangxvhao.demo.mapper.PersonMapper.selectList");
        PersonMapper personMapper =  sqlSession.getMapper(PersonMapper.class);
        List<Person> people1 = personMapper.selectList();
        System.out.println(Arrays.toString(people.toArray()));
    }
    
}
