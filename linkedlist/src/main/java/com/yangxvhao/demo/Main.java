package com.yangxvhao.demo;

import org.springframework.util.StopWatch;

import java.util.Random;


/**
 * @author yangxvhao
 * @date 17-12-25.
 */

public class Main {
    public static void main(String[] args) throws Exception {
        StopWatch watch = new StopWatch();
        watch.start();
        Random random = new Random();
        Integer integer = 0;
        SortList<Integer> linkedList = new SortList<>();
        for(int i = 0; i < 10000000; i ++){
            if(i == 55555){
                integer = random.nextInt();
                linkedList.insert(integer);
                continue;
            }
            linkedList.insert(random.nextInt());

        }
        watch.stop();
        System.out.println("insert time:" + watch.getLastTaskTimeMillis());

        watch.start();
        SortList<Integer>.Node node = linkedList.find(integer);
        System.out.println(node.getData());
        watch.stop();
        System.out.println("find time:" + watch.getLastTaskTimeMillis());
    }
}
