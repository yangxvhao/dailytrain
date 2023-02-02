package com.yangxvhao.demo.proxy.offer;

/**
 * 快手一面
 * 最大回文子串
 *
 * @author yangxvhao
 * @date 2023-01-20 14:33.
 */
public class Audition004 {
    /**
     * 动态规划：
     * 1.状态定义：dp[i][j]表示从i到j是否是回我串
     * 2.转移方程：dp[i][j]=(lstr[i]==str[j])&&(len==2||dp[i+1][j-1])
     * 3.初始值：子串len==1,必然为true，dp[0][0],dp[1][1]..=true
     * 4.循环：子串len:2-str.length
     * 可以把初始值初始化放在循环里面，合并
     *
     * @param str
     * @return
     */
    public String longestPalindrome(String str) {
        int strLen = str.length();
        if (strLen == 0 || strLen == 1) {
            return str;
        }
        boolean[][] dp = new boolean[strLen][strLen];

        for (int i = 0; i < strLen; i++) {
            dp[i][i] = true;
        }
        //用变量记录最大值，减少一次遍历
        int maxStart = 0, maxEnd = 0, maxLen = 0;
        for (int len = 2; len <= strLen; len++) {
            for (int start = 0; start < strLen - 1; start++) {
                int end = start + len - 1;
                if (end >= strLen) {
                    break;
                }
                if (str.charAt(start) == str.charAt(end)) {
                    dp[start][end] = len == 2 || dp[start + 1][end - 1];
                } else {
                    dp[start][end] = false;
                }
                if (dp[start][end] && maxLen < len) {
                    maxLen = len;
                    maxStart = start;
                    maxEnd = end;
                }
            }
        }
        return str.substring(maxStart, maxEnd + 1);
    }

    public static void main(String[] args) {
        System.out.println(new Audition004().longestPalindrome("babad"));
        System.out.println(new Audition004().longestPalindrome("cbbd"));
    }
}
