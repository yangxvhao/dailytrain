package com.yangxvhao.demo.proxy;

import com.google.common.collect.Lists;
import com.yangxvhao.demo.proxy.model.Person;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

    @Test
    public void testSort(){
        List<Person> list = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            Person person = null;
            if(i % 3 == 0){
                person = new Person("dd", 10, i);
            }else if(i % 4 == 0){
                person = new Person("dd", 11, i);
            }else if(i % 5 == 0){
                person = new Person("cc", 12, i);
            }else if(i % 6 == 0){
                person = new Person("cc", 10, i);
            }else if(i % 7 == 0){
                person = new Person("aa", 10, i);
            }else {
                person = new Person("aa", 18, i);
            }
            list.add(person);
        }
//        Person person = new Person("dd", 10, 0);
//        Person person0 = new Person("dd", 10, 1);
//        Person person1 = new Person("dd", 11, 2);
//        Person person2 = new Person("cc", 12, 3);
//        Person person5 = new Person("cc", 18, 4);
//        Person person3 = new Person("bb", 10, 5);
//        Person person4 = new Person("bb", 11, 6);
//        List<Person> list = Lists.newArrayList(person,person0, person1, person2, person3, person4, person5);
        List<String> sort = Lists.newArrayList("name", "age");
        list.sort((o1, o2) ->{
            int flag = 0;
            for (String s : sort) {
                switch (s){
                    case "name":
                        flag = o1.getName().compareTo(o2.getName());
                        break;
                    case "age":
                        flag = Integer.compare(o2.getAge(), o1.getAge());
                        break;
                    case "id":
                        flag = Integer.compare(o1.getId(), o2.getId());
                        break;
                }
                if(flag != 0){
                    return flag;
                }
            }
            return flag;
//            int flag = Integer.compare(o1.getAge(), o2.getAge());
//            if(flag == 0){
//                return o1.getName().compareTo(o2.getName());
//            }else {
//                return flag;
//            }
        });
        System.out.println();
    }
}
