package com.yangxvhao.demo.proxy.offer;

import java.util.HashSet;
import java.util.PriorityQueue;

/**
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 * @author yangxvhao
 * @date 2023-01-25 14:20.
 */
public class Topic49 {
    public int nthUglyNumber(int n) {
//        return method1(n);
        return method2(n);
    }

    /**
     * 常规方法：使用小顶堆，堆订保存最小丑数，取n次即可取到第n个丑数
     *
     * @param n
     * @return
     */
    private int method1(int n) {
        PriorityQueue<Long> priorityQueue = new PriorityQueue<>();
        //去重
        HashSet<Long> set = new HashSet<>();

        priorityQueue.add(1L);
        int[] bases = new int[]{2, 3, 5};
        long cur = 0;
        for (int i = 0; i < n; i++) {
            cur = priorityQueue.isEmpty() ? 1 : priorityQueue.poll();
            for (int base : bases) {
                if (set.add(base * cur)) {
                    priorityQueue.add(base * cur);
                }
            }
        }

        return (int) cur;
    }

    /**
     * 动态规划：
     * 状态：dp[i]表示第i个丑数
     * 转移方程：dp[i]=min(dp[p2]*2,dp[p3]*3,dp[p5]*5),p2,p3,p5表示由上一个丑数*2，3，5得到
     * base：dp[0]=1;
     * 顺序：0-n
     *
     * @param n
     * @return
     */
    private int method2(int n) {
        int[] dp = new int[n];
        int p2 = 0, p3 = 0, p5 = 0;
        dp[0] = 1;
        for (int i = 1; i < n; i++) {
            dp[i] = Math.min(Math.min(dp[p2] * 2, dp[p3] * 3), dp[p5] * 5);
            if (dp[i] == dp[p2] * 2) {
                p2++;
            }
            if (dp[i] == dp[p3] * 3) {
                p3++;
            }
            if (dp[i] == dp[p5] * 5) {
                p5++;
            }
        }
        return dp[n - 1];
    }

    public static void main(String[] args) {
        System.out.println(new Topic49().nthUglyNumber(12));
        System.out.println(new Topic49().nthUglyNumber(1407));
    }
}
