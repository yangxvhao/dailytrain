package com.yangxvhao.demo.proxy.offer;

/**
 * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1] 可能的最大乘积是多少？例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
 * <p>
 * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/jian-sheng-zi-ii-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yangxvhao
 * @date 2022-12-04 17:03.
 */
public class Topic14to2 {
    public int cuttingRope(int n) {
        if (n <= 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int num1 = n / 3;
        int num2 = n % 3;
        long rem = 1L;
        int p = (int) 1e9 + 7;
        for (int i = 1; i < num1; i++) {
            rem = (rem * 3) % p;
        }
        if (num2 == 1) {
            return (int) ((rem * 4) % p);
        }
        if (num2 == 2) {
            return (int) ((rem * 6) % p);
        }
        return (int) (rem * 3) % p;
    }

    public static void main(String[] args) {
        System.out.println(new Topic14to2().cuttingRope(127));
    }
}
