package com.yangxvhao.demo.proxy.offer;

import java.util.Arrays;

/**
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * @author yangxvhao
 * @date 2023-01-27 20:04.
 */
public class Topic56 {
    /**
     * 利用位运算
     *
     * @param nums
     * @return
     */
    public int[] singleNumbers(int[] nums) {
        // 设两个不同数字为x,y,相同的数字异或为0
        int x = 0, y = 0, n = 0, m = 1;
        // n = x 异或 y
        for (int num : nums) {
            n = n ^ num;
        }
        // 找到x和y第一位不同的数=m
        while ((n & m) == 0) {
            m = m << 1;
        }
        //利用m把nums分为2组，分别只包括x,y
        for (int num : nums) {
            if ((num & m) == 0) {
                x = x ^ num;
            } else {
                y = y ^ num;
            }
        }
        return new int[]{x, y};
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Topic56().singleNumbers(new int[]{4, 1, 4, 6})));
    }
}
