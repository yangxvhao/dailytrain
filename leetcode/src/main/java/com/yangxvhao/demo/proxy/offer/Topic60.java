package com.yangxvhao.demo.proxy.offer;

import java.util.Arrays;

/**
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/nge-tou-zi-de-dian-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yangxvhao
 * @date 2023-01-29 20:52.
 */
public class Topic60 {
    /**
     * 利用动态规划
     * 1.状态f(n,x)表示n个骰子，和为x的概率
     * 2.转移方程：f(n,x)=f(n-1,x-1)*1/6+f(n-1,x-2)*1/6...f(n-1,x-5)*1/6
     * 3.初始化:f(1,1)=1/6,f(1,2)=1/6...
     *
     * @param n
     * @return
     */
    public double[] dicesProbability(int n) {
        double[][] dp = new double[n + 1][6 * n + 1];

        for (int i = 1; i <= 6; i++) {
            dp[1][i] = 1 / 6.0;
        }

        for (int i = 2; i <= n; i++) {
            //n个骰子出现的和的个数是(6*n-n+1)=5n+1
            for (int j = i; j <= 6 * i; j++) {
                for (int k = 1; k <= 6; k++) {
                    if (j - k > 0) {
                        dp[i][j] = dp[i][j] + dp[i - 1][j - k] / 6.0;
                    } else {
                        break;
                    }
                }

            }
        }

        double[] ans = new double[5 * n + 1];
        for (int i = 0; i < ans.length; i++) {
            ans[i] = dp[n][i + n];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Topic60().dicesProbability(1)));
        System.out.println(Arrays.toString(new Topic60().dicesProbability(2)));
    }
}
