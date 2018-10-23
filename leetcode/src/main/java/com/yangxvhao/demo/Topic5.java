package com.yangxvhao.demo;

/**
 * 给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为1000。
 * @author yangxvhao
 * @date 2018-08-08 下午7:35.
 */
public class Topic5 {
    public static void main(String[] args) {
        longestPalindrome("abadc");
    }
    public static String longestPalindrome(String s) {
        int[] ascii = new int[127];
        int i =0;
        for (char c : s.toCharArray()) {
            ascii[c] += 1;
            if(ascii[c] == 2){
                return "";
            }
            i++;
        }
        return "";
    }
}
