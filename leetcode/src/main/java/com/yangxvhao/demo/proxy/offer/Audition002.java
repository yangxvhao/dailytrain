package com.yangxvhao.demo.proxy.offer;

import java.util.Arrays;

/**
 * 小红书CRM一面
 * 第一天发一块钱，第2次每天发2块钱，第3次每天发3块钱
 * 1 2 2 3 3 3 4 4 4 4...
 *
 * @author yangxvhao
 * @date 2022-12-30 17:16.
 */
public class Audition002 {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Audition002().help(new int[]{6,7,10})));
    }

    public int[] help(int[] days) {
        if (days == null || days.length == 0) {
            return null;
        }
        int[] res = new int[days.length];
        // 1+2+3+4+n=((n+1)*n)/2
        for (int k = 0; k < days.length; k++) {
            int day = days[k];
            int i = 1;
            while ((i * (i + 1)) / 2 < day) {
                i++;
            }
            int last = day - (i * (i - 1)) / 2;
            //1^2+2^2+3^2+n^2=n*(n+1)*(2n+1)/6
            int n = i-1;
            int amount = n*(n+1)*(2*n+1)/6;
//            for (int j = 1; j < i; j++) {
//                amount = amount + (j * j);
//            }
            amount = amount + last * i;
            res[k] = amount;
        }
        return res;
    }
}
