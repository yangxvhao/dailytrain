package com.yangxvhao.demo.proxy;

import org.springframework.util.StopWatch;

import java.util.Random;


/**
 * @author yangxvhao
 * @date 17-12-25.
 */

public class Main {
    public static void main(String[] args) throws Exception {
        /**
         * 假装一个表格2行3列
         * 1, 3, 4
         * 2, 3, 4
         *
         */
        Integer[][] integers = {{1, 3, 4}, {2, 3, 4}};
        //i=0 代表开始的行，假如你得表格需要从第3行开始处理，就写i=2
        for (int i = 0; i < integers.length; i++) {
            //j=0 代表开始的列，比如你的表格是处理第二列之后的，那就是j=1开始
            for (int j = 0; j < integers[i].length; j++) {
                integers[i][j] = integers[i][j] + 1; //你想做的处理，我这里举个例子是+1，你那里就是保留2位小数
            }
        }

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
