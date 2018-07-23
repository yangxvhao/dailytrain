package com.yangxvhao.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个字符串，找出不含有重复字符的最长子串的长度。
 *
 * 示例：
 *
 * 给定 "abcabcbb" ，没有重复字符的最长子串是 "abc" ，那么长度就是3。
 *
 * 给定 "bbbbb" ，最长的子串就是 "b" ，长度是1。
 *
 * 给定 "pwwkew" ，最长子串是 "wke" ，长度是3。请注意答案必须是一个子串，"pwke" 是 子序列  而不是子串。
 * 
 * @author yangxvhao
 * @date 2018-07-23 下午6:06.
 */
public class Topic3 {
    public static void main(String[] args) {
        lengthOfLongestSubstring("abcabcbb");
    }

    public static int lengthOfLongestSubstring(String s) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < s.toCharArray().length - 1; i++) {
            String sumStr = String.valueOf(s.charAt(i));
            list.add(String.valueOf(s.charAt(i)));
            for(int j = i +1; j < s.toCharArray().length; j ++){
                sumStr += String.valueOf(s.charAt(j));
                list.add(sumStr);
            }
        }

        for (String s1 : list) {
            
        }
        return 0;
    }
    
    private static boolean isContains(String s){
        for (char c : s.toCharArray()) {
            if(s.contains(c)){
                return false;
            }
        }
        return true;
    }
}
