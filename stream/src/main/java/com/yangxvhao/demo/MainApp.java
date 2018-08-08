package com.yangxvhao.demo;


import java.util.*;
import java.util.stream.Collectors;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * A Camel Application
 */
public class MainApp {
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
        
        List listM = new ArrayList(map.entrySet());
        System.out.println();
        //step1 流的构造
        Stream stream0 = Stream.of("");

        String[] strings = new String[]{""};
        Stream stream1 = Stream.of(strings);
        Stream stream2 = Arrays.stream(strings);

        List<String> list = Arrays.asList(strings);
        Stream stream3 = list.stream();

        //三种基本类型对应的包装类型stream，
        //Stream<Integer>、Stream<Long> >、Stream<Double>
        //boxing 和 unboxing 会很耗时，所以特别为这三种基本数值型提供了对应的 Stream。
        IntStream intStream = IntStream.of(1, 2, 3, 4, 6, 3, 12, 12, 3);
//        intStream.average().ifPresent(System.out::println);
//        intStream.forEachOrdered(System.out::print);
//        IntStream.range(1,10).forEach(System.out::println);
//        IntStream.rangeClosed(1,10).forEach(System.out::println);
        
//        DoubleStream doubleStream = intStream.asDoubleStream();
//        doubleStream.map(operand -> operand);
        
//        LongStream longStream = intStream.asLongStream();


        System.out.println("hello world");
    }

}

