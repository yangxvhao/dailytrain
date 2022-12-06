package com.yangxvhao.demo.proxy.offer;

import java.util.Arrays;

/**
 * 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有奇数在数组的前半部分，所有偶数在数组的后半部分。
 *
 * @author yangxvhao
 * @date 2022-12-05 21:48.
 */
public class Topic21 {
    public int[] exchange(int[] nums) {
        int left = 0, right = nums.length - 1;
        while (left < right) {
            while (left < right && (nums[left] & 1) == 1) {
                left++;
            }
            while (left < right && (nums[right] & 1) == 0) {
                right--;
            }
            int tmp = nums[right];
            nums[right] = nums[left];
            nums[left] = tmp;
        }
        return nums;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Topic21().exchange(new int[]{1, 2, 3, 4})));
    }
}
