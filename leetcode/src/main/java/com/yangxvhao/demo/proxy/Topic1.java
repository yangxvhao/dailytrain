package com.yangxvhao.demo.proxy;

/**
 *
 给定一个整数数组和一个目标值，找出数组中和为目标值的两个数。

 你可以假设每个输入只对应一种答案，且同样的元素不能被重复利用
 
 * @author yangxvhao
 * @date 2018-07-16 下午7:23.
 */
public class Topic1 {
    public static void main(String[] args) {
        int[] result = twoSum(new int[]{3,2,4}, 6);
        System.out.println();
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int i1 = nums.length - 1; i1 > 0; i1--) {
                if (nums[i] + nums[i1] == target)
                    return new int[]{i, i1};
            }
        }
        return null;
    }
}
