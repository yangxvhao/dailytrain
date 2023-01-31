package com.yangxvhao.demo.proxy.offer;

/**
 * 假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖该股票一次可能获得的最大利润是多少？
 *
 * @author yangxvhao
 * @date 2023-01-30 16:16.
 */
public class Topic63 {

    public int maxProfit(int[] prices) {
//        return method1(prices);
        return method2(prices);
    }

    /**
     * 动态规划
     * 1.状态：dp[i]表示前i日的最大利润
     * 2.状态转移：dp[i]=max(dp[i-1,prices[i]-min(prices[i-1]))
     * 3.初始值：dp[0]=0
     * 4.遍历：
     *
     * @param prices
     * @return
     */
    private int method2(int[] prices) {
        int[] dp = new int[prices.length];
        int min = prices[0];
        dp[0] = 0;
        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
            if (prices[i] < min) {
                min = prices[i];
            }
        }
        int max = 0;
        for (int i : dp) {
            max = Math.max(i, max);
        }
        return max;
    }

    /**
     * 常规思路
     * 遍历，记录最小值，记录当前值和最小值的差值，拿当前值和最小值的差和记录的差值比较
     *
     * @param prices
     * @return
     */
    private int method1(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int min = prices[0];
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > min) {
                max = Math.max(max, prices[i] - min);
            } else {
                min = prices[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        System.out.println(new Topic63().maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(new Topic63().maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
