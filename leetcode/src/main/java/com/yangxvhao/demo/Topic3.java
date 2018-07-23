package com.yangxvhao.demo;

import org.springframework.util.StopWatch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 * <p>
 * 示例：
 * <p>
 * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 * <p>
 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 * <p>
 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 *
 * @author yangxvhao
 * @date 2018-07-23 下午6:06.
 */
public class Topic3 {
    public static void main(String[] args) {
        StopWatch start = new StopWatch();
        start.start();
        System.out.println(lengthOfLongestSubstring("puuywsnezdufctcjqmrkiwhwerepqyehsyirqvxryrwbmbmepfpzeyvkrzajzesteakwvhnwalznmnrbu"));
        start.stop();
        System.out.println(start.getLastTaskTimeMillis());
        ;
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s.isEmpty()) {
            return 0;
        }
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.toCharArray().length; ++i) {
            String sumStr = String.valueOf(s.charAt(i));
            list.add(String.valueOf(s.charAt(i)));
            for (int j = i + 1; j < s.toCharArray().length; ++j) {
                sumStr += String.valueOf(s.charAt(j));
                list.add(sumStr);
            }
        }
        Iterator<String> iterator = list.iterator();
        List<Integer> count = new ArrayList<>();
        while (iterator.hasNext()) {
            String s1 = iterator.next();
            if (!isRepeat(s1)) {
                count.add(s1.length());
            }
        }
        Collections.sort(count);
        return count.get(count.size() - 1);
    }

    private static boolean isRepeat(String s) {
        int[] ascii = new int[127];
        for (char c : s.toCharArray()) {
            ascii[c] += 1;
        }
        for (int i : ascii) {
            if (i > 1) {
                return true;
            }
        }
        return false;
    }
}
