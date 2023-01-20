package com.yangxvhao.demo.proxy.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 数组中有一个数字出现的次数超过数组长度的一半，请找出这个数字。
 * 你可以假设数组是非空的，并且给定的数组总是存在多数元素。
 *
 * @author yangxvhao
 * @date 2023-01-20 10:31.
 */
public class Topic39 {
    public int majorityElement(int[] nums) {
//        return hashMapMethod(nums);
        return voteMethod(nums);
    }

    /**
     * map 计数
     *
     * @param nums
     * @return
     */
    private int hashMapMethod(int[] nums) {
        Map<Integer, Integer> numCountMap = new HashMap<>();
        for (int num : nums) {
            numCountMap.merge(num, 1, Integer::sum);
        }
        for (Map.Entry<Integer, Integer> entry : numCountMap.entrySet()) {
            if (entry.getValue() > nums.length / 2) {
                return entry.getKey();
            }
        }
        return 0;
    }

    /**
     * 摩尔投票
     *
     * @param nums
     * @return
     */
    private int voteMethod(int[] nums) {
        int vote = 0, x = 0;
        for (int num : nums) {
            if (vote == 0) {
                x = num;
            }
            vote = vote + (x == num ? 1 : -1);
        }
        return x;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1, 2, 2, 2, 2, 3, 1, 2};
        System.out.println(new Topic39().majorityElement(nums));
    }
}
