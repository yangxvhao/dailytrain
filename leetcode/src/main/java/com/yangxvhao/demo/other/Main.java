package com.yangxvhao.demo.other;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

/**
 * @author yangxuhao
 * @date 2019-04-12 18:40.
 */
public class Main {
    public static void main(String[] args) {
        Long start = System.currentTimeMillis();
        int num0 = 866278171;
        boolean [] num1 = new boolean[num0];
        for (int i = 0; i < num0; i++) {
            if(i % 2 == 1) {
                num1[i] = true;
            }
        }
        int count = 0;
        for (int i = 0; i < num1.length; i++) {
            if(num1[i]) {
                String str = i + "";
                List chars = Arrays.asList(str.toCharArray());
                if(chars.contains("3")){
                    count++;
                }
            }
        }
        Long end = System.currentTimeMillis();
        System.out.println("count:" + count + ", cost time:" + (end - start / 1000) + "ms");

//        int num = 100000;
//        List<Integer> integers = Lists.newArrayList();
//        boolean[] isPrime = sieveOfEratosthenes(num);
//        for (int i = 0; i < num; i++) {
//            if(isPrime[i]){
//                integers.add(i);
//            }
//        }
//
//        int result = 707829217;
//        integers.forEach(integer -> {
//            integers.forEach(integer1 -> {
//                if(integer * integer1 == result){
//                    System.out.println(integer + " * " + integer1);
//                }
//            });
//        });
    }

    public static boolean[] sieveOfEratosthenes(int n) {
        boolean[] isPrime = new boolean[n + 1];
        //初始化，默认所有都是质数
        for (int i = 0; i <= n; i++) {
            isPrime[i] = true;
        }
        //筛选，将所有质数的倍数都标记为非质数(最初只知道2是质数)
        for (int i = 2; i <= n / i; i++) {
            if (isPrime[i]) {
                for (int j = 2; j <= n / i; j++) {
                    isPrime[i * j] = false;
                }
            }
        }
        return isPrime;
    }


}
