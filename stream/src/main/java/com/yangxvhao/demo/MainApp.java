package com.yangxvhao.demo;


import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * A Camel Application
 */
public class MainApp {

    /**
     * A main() so we can easily run these routing rules in our IDE
     */
    public static void main(String... args) throws Exception {
//        String [] strings1 = new String[]{"aaa", "sss", "sdjgji"};
//        String [] strings2 = new String[]{"bbb", "dddd", "ddfdfda"};
//
//        List<String> list1 = Arrays.asList(strings1);
//        List<String> list2 = Arrays.asList(strings2);
//        
//        List<String> result = Stream.of(list1, list2).flatMap(Collection::stream).collect(Collectors.toList());
//        
        Map<String, String> map = new HashMap<>();
        map.put("111", "aaa");
        map.put(null, null);
        
        List list = new ArrayList(map.entrySet());
        System.out.println();
    }

}

