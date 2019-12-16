package com.yangxvhao.demo;

/**
 * 实现开方
 *
 * @author yangx
 * @date 2019-12-11 21:37.
 */
public class MySqrt {
    public static void main(String[] args) {
//        System.out.println(sqrt(10));
        System.out.println(sqrtByBinary(10, 0.001));
    }

    public static double sqrtByBinary(int source, double target){
        double n = source;
        double l = 0.0;
        double h = source ;
        int m = (int) ((l + h) / 2);
        if(m * m == n){
            return m;
        }
        int count = 0;
        while (l <= h){
            count++;
            if(m * m < n){
                l = m;
            }
            if(m * m > n){
                h = m;

            }
            m = (int) (l + ((h - l) / 2));
        }
        System.out.println("count :" + count);
        return m;
    }

    public static int sqrt(int x) {
        int low = 0;
        int high = x;
        while (low <= high) {
            long mid = (low + high) / 2;//防止溢出
            if (mid * mid == x)
                return (int) mid;
            else if (mid * mid < x)
                low = (int) (mid + 1);
            else
                high = (int) (mid - 1);
        }
        return high;
    }

}
