package com.yangxvhao.demo.proxy.offer;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m-1] 。请问 k[0]*k[1]*...*k[m-1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/jian-sheng-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yangxvhao
 * @date 2022-12-04 16:17.
 */
public class Topic14to1 {
    public int cuttingRope(int n) {
        //return greed(n);
        return dp(n);
    }

    private int dp(int n) {
        int[] dp = new int[n + 1];
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 2; j < i; j++) {
                int tmp = Math.max(j * (i - j), j * dp[i - j]);
                dp[i] = Math.max(dp[i], tmp);
            }
        }
        return dp[n];
    }

    private int greed(int n) {
        if (n <= 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int num1 = n / 3;
        int num2 = n % 3;
        if (num2 == 1) {
            return (int) Math.pow(3, num1 - 1) * 4;
        }
        if (num2 == 2) {
            return (int) Math.pow(3, num1) * 2;
        }
        return (int) Math.pow(3, num1);
    }

    public static void main(String[] args) {
        System.out.println(new Topic14to1().cuttingRope(3));
        System.out.println(new Topic14to1().cuttingRope(10));
    }
}
