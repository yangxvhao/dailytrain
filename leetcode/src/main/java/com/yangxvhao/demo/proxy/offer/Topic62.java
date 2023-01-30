package com.yangxvhao.demo.proxy.offer;

/**
 * 0,1,···,n-1这n个数字排成一个圆圈，从数字0开始，每次从这个圆圈里删除第m个数字（删除后从下一个数字开始计数）。求出这个圆圈里剩下的最后一个数字。
 *
 * @author yangxvhao
 * @date 2023-01-29 21:22.
 */
public class Topic62 {
    /**
     * 动态规划
     * 1.状态：dp[i]表示i=n的解
     * 2.转移：dp[i]=(dp[i-1]+m)%i
     * 3.初始:dp[1]=0;
     * 4.顺序：2~n
     * 转移方程的推导：
     *
     * @param n
     * @param m
     * @return
     */
    public int lastRemaining(int n, int m) {
        int tmp = 0;
        for (int i = 2; i <= n; i++) {
            tmp = (tmp + m) % i;
        }
        return tmp;
    }

    public static void main(String[] args) {
        System.out.println(new Topic62().lastRemaining(5, 3));
    }
}
