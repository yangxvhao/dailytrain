package com.yangxvhao.demo.proxy.offer;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 在字符串 s 中找出第一个只出现一次的字符。如果没有，返回一个单空格。 s 只包含小写字母。
 *
 * @author yangxvhao
 * @date 2023-01-25 15:27.
 */
public class Topic50 {
    public char firstUniqChar(String s) {
//        return method1(s);
        return method2(s);
    }

    /**
     * 常规思路：用hashMap统计每个字符出现的次数，输出第一个次数为1 的字符
     *
     * @param s
     * @return
     */
    private char method1(String s) {
        HashMap<Character, Integer> dict = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (dict.containsKey(c)) {
                dict.put(c, dict.get(c) + 1);
            } else {
                dict.put(c, 1);
            }
        }
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (dict.get(c) == 1) {
                return c;
            }
        }
        return ' ';
    }

    /**
     * 空间优化：使用数组
     *
     * @param s
     * @return
     */
    private char method2(String s) {
        int[] arr = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            arr[c - 'a']++;
        }
        for (int i = 0; i < s.length(); i++) {
            if (arr[s.charAt(i) - 'a'] == 1) {
                return s.charAt(i);
            }
        }
        return ' ';
    }

    /**
     * 时间优化：使用linkedhashmap记录插入顺序
     *
     * @param s
     * @return
     */
    private char method3(String s) {
        LinkedHashMap<Character, Boolean> map = new LinkedHashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.put(c, !map.containsKey(c));
        }
        for (Map.Entry<Character, Boolean> entry : map.entrySet()) {
            if (entry.getValue()) {
                return entry.getKey();
            }
        }
        return ' ';
    }

    public static void main(String[] args) {
        System.out.println(new Topic50().firstUniqChar("abaccdeff"));
    }
}
