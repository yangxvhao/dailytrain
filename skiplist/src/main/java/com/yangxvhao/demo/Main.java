package com.yangxvhao.demo;

import java.util.concurrent.ConcurrentSkipListMap;

/**
 * @author yangxvhao
 * @date 17-12-19.
 */
public class Main {
    public static void main(String[] args) {

        ConcurrentSkipListMap skipListMap = new ConcurrentSkipListMap();
        skipListMap.put("hello","world");
        System.out.println(skipListMap.firstEntry().getKey());
    }
}
