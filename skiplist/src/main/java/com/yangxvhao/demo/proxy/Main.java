package com.yangxvhao.demo.proxy;

import org.springframework.util.StopWatch;

import java.util.HashMap;
import java.util.Random;

/**
 * @author yangxvhao
 * @date 17-12-19.
 */
public class Main {
    public static void main(String[] args) {
        HashMap<String, String> map = new HashMap<>(4);
        map.put("a", "a");
        System.out.println();

        SkipList<Integer> skipList = new SkipList<>();
        StopWatch watch = new StopWatch();
        watch.start();
        Random random = new Random();
        Integer integer = 0;
        double doublerandom = 0.0;
        for(int i = 0; i < 10000000; i ++){
            if(i == 55555){
                integer = random.nextInt();
                doublerandom = random.nextDouble();
                System.out.println(doublerandom);
                System.out.println(integer);
                skipList.insert(doublerandom,integer);
                continue;
            }
            skipList.insert(random.nextDouble(),random.nextInt());

        }
        watch.stop();
        System.out.println("insert time:" + watch.getLastTaskTimeMillis());

        watch.start();
        Integer integer1 = skipList.get(doublerandom);
        System.out.println(integer1);
        watch.stop();
        System.out.println("find time:" + watch.getLastTaskTimeMillis());
//        int count = 0;
//        int sum = 100000;
//        for(int i = 0; i < sum; i ++) {
//            if(new Random().nextInt() % 2 == 0){
//                count ++;
//            }
//
//        }
//        System.out.println((count * 1.0)/sum);
    }
}
