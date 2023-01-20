package com.example.demo;

import java.util.ArrayList;
import java.util.List;

/**
 * 给你一个字符串 s，找到 s 中最长的回文子串。
 * <p>
 * 如果字符串的反序与原始字符串相同，则该字符串称为回文字符串。
 *
 * @author yangxvhao
 * @date 2023-01-13 14:46.
 */
public class Test {

    /**
     * 暴力解法
     *
     * @param str
     * @return
     */
    public static String longestPalindrome(String str) {
        if (str.length() == 1) {
            return str;
        }
        // abcdcbe
        char[] chars = str.toCharArray();
        List<String> stringList = new ArrayList<>();
        //生成所有子串
        for (int i = 0; i < chars.length - 1; i++) {
            String tmp = "" + chars[i];
            stringList.add(tmp);
            String tmpS = tmp;
            for (int j = i + 1; j < chars.length; j++) {
                tmpS = tmpS + chars[j];
                stringList.add(tmpS);
            }
        }
        // 遍历
        int length = 0;
        int index = 0;
        for (int i = 0; i < stringList.size(); i++) {
            String s = stringList.get(i);
            // 检测子串是否是回文，并判断长度是否是最大
            if (s.equals(help(s)) && length < s.length()) {
                length = s.length();
                index = i;
            }
        }
        return stringList.get(index);
    }

    public static String help(String param) {
        char[] chars = param.toCharArray();
        char[] result = new char[chars.length];
        int j = 0;
        for (int i = chars.length - 1; i >= 0; i--) {
            result[j] = chars[i];
            j++;
        }
        return String.valueOf(result);
    }

    /**
     * 动态规划
     * dp数组：dp[i][j] i是字符串开始位置，j是结束位置，值为是否回文
     * 初始值：dp[0][0] dp[1][1] .. =true
     * 状态转换方程：dp[i][j]=s[i]s[j]&&dp[i+1][j-1]
     * 终止条件：i>j
     *
     * @param str
     * @return
     */
    public static String longestPalindromeOpt(String str) {
        if (str.length() == 1) {
            return str;
        }
        char[] chars = str.toCharArray();
        int length = chars.length;
        boolean[][] dp = new boolean[length][length];
        int maxLen = 0;
        int maxStart = 0, maxEnd = 0;

        for (int len = 1; len <= length; len++) {
            for (int start = 0; start < length; start++) {
                int end = start + len - 1;
                if (end >= length) {
                    break;
                }
                dp[start][end] = len == 1 || (chars[start] == chars[end] && (len == 2 || dp[start + 1][end - 1]));
//                if (chars[start] == chars[end]) {
//                    if (len == 1 || len == 2) {
//                        dp[start][end] = true;
//                        break;
//                    }
//                    if (dp[start + 1][end - 1]) {
//                        dp[start][end] = true;
//                        break;
//                    }
//                }
                if (dp[start][end] && maxLen < len) {
                    maxLen = len;
                    maxEnd = end;
                    maxStart = start;
                }
            }
        }

        return str.substring(maxStart, maxEnd + 1);

    }

    public static void main(String[] args) {
        System.out.println(longestPalindromeOpt("abacd"));
    }

}
