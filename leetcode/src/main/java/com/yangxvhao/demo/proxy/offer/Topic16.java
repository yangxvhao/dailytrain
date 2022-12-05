package com.yangxvhao.demo.proxy.offer;

/**
 * 实现 pow(x, n) ，即计算 x 的 n 次幂函数（即，xn）。不得使用库函数，同时不需要考虑大数问题。
 *
 * @author yangxvhao
 * @date 2022-12-04 18:08.
 */
public class Topic16 {
    public double myPow(double x, int n) {
        if (x == 0) {
            return 0;
        }
        long b = n;
        double res = 1.0;
        if (n < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                res = res * x;
            }
            x = x * x;
            b = b >> 1;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Topic16().myPow(2.0, 100));
        System.out.println(new Topic16().myPow(2.1, 3));
        System.out.println(new Topic16().myPow(2.0, -2));
    }
}
