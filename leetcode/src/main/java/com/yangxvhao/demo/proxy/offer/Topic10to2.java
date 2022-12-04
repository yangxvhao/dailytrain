package com.yangxvhao.demo.proxy.offer;

/**
 * 一只青蛙一次可以跳上1级台阶，也可以跳上2级台阶。求该青蛙跳上一个 n 级的台阶总共有多少种跳法。
 *
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/qing-wa-tiao-tai-jie-wen-ti-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author yangxvhao
 * @date 2022-12-03 15:44.
 */
public class Topic10to2 {
    /**
     * 台阶 0 1 2 3 4 n-2 n-1 n
     * 跳法 1 1 2 3 5         f(n-1) + f(n-2)
     * @param n
     * @return
     */
    public int numWays(int n) {
        int a = 1, b= 1;
        for (int i = 1; i < n; i++) {
            a = a + b;
            b = a - b;
            a = a % 1000000007;
        }
        return a;
    }

    public static void main(String[] args) {
        System.out.println(new Topic10to2().numWays(1));
        System.out.println(new Topic10to2().numWays(2));
        System.out.println(new Topic10to2().numWays(3));
        System.out.println(new Topic10to2().numWays(30));
    }
}
