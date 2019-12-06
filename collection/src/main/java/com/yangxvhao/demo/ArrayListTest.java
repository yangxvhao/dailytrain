package com.yangxvhao.demo;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;
import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;
import com.yangxvhao.demo.model.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author yangxuhao
 * @date 2019-11-26 12:06.
 */
public class ArrayListTest {
    @Test
    public void testCopy(){
        /**
         * 浅复制，里面的对象还是同一个，修改list1依然会改变list2里面对象的值
         */
        List<Person> list1 = new ArrayList<>();
        Person person = new Person();
        person.setAge(1);
        person.setName("aaa");
        list1.add(person);

        List<Person> list2 = new ArrayList<>(list1);

        list1.get(0).setName("aaa change");

        Assert.assertSame("aaa change", list2.get(0).getName());
    }

    @Test
    public void testArrayList(){
        List<String> list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");

//        list.removeIf(s -> s.equals("2"));

        for (int i = 0; i < list.size(); i++) {
            list.remove(list.get(i));
        }
//        for (String integer : list) {
//            if(integer.equals("1")){
//                list.remove(1);
//            }
//        }
        System.out.println();
    }

    @Test
    public void testInteger(){
        Integer integer1 = 2;
        Integer integer2 = 2;
        System.out.println(integer1 == ( integer2));
        Integer integer100 = 200;
        Integer integer200 = 200;
        System.out.println(integer100 == ( integer200));

    }

    @Test
    public void testString(){
        String a = "a";
        String b = "b";

//        ab.intern();
        String ab1 = "ab";
        String ab2 = "a" + "b";
        String ab = a + b;
        String ab3 = new String("ab");
        System.out.println(ab == ab1);
        System.out.println(ab == ab2);
        System.out.println(ab1 == ab2);
    }

    @Test
    public void testListClassType(){
        List<Integer> integerList = new ArrayList<>();
            List<LinkedListDemo> stringList = new ArrayList<>();
        System.out.println(integerList.getClass() == stringList.getClass());
    }
}
