package com.yangxvhao.demo.proxy.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 请从字符串中找出一个最长的不包含重复字符的子字符串，计算该最长子字符串的长度。
 *
 * @author yangxvhao
 * @date 2023-01-24 17:16.
 */
public class Topic48 {
    public int lengthOfLongestSubstring(String s) {
//        return dp(s);
        return window(s);
    }

    /**
     * 状态：dp[i]表示以s[i]结尾最长的不包含重复字符的子字符串
     * 转移方程：j为离i最近的重复字符
     * 1.dp[i]=dp[i-1]+1 (dp[i-1]<i-j)
     * 2.dp[i]=i-j (dp[i]>=i-j)
     * 初始值dp[0]=1;
     * 顺序：i:0-length
     *
     * @param s
     * @return
     */
    private int dp(String s) {
        char[] chars = s.toCharArray();
        int[] dp = new int[chars.length + 1];
        Map<Character, Integer> dict = new HashMap<>();

        dp[0] = 0;
        int max = dp[0];
        for (int i = 0; i < chars.length; i++) {
            int j = dict.getOrDefault(chars[i], -1);
            if (dp[i] < i - j) {
                dp[i + 1] = dp[i] + 1;
            } else {
                dp[i + 1] = i - j;
            }
            dict.put(chars[i], i);
            if (dp[i + 1] > max) {
                max = dp[i];
            }
        }
        return max;

    }

    /**
     * 双指针，滑动窗口
     *
     * @param s
     * @return
     */
    private int window(String s) {
        Map<Character, Integer> dict = new HashMap<>();
        int max = 0, j = -1;
        for (int i = 0; i < s.length(); i++) {
            if (dict.containsKey(s.charAt(i))) {
                j = Math.max(dict.get(s.charAt(i)), j);
            }
            if (i - j > max) {
                max = i - j;
            }
            dict.put(s.charAt(i), i);

        }
        return max;
    }

    public static void main(String[] args) {
//        System.out.println(new Topic48().lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(new Topic48().lengthOfLongestSubstring("bbbbb"));
        System.out.println(new Topic48().lengthOfLongestSubstring("pwwkew"));
    }
}
