package com.yangxvhao.demo.proxy.offer;

/**
 * 找出数组中重复的数字。
 *
 *
 * 在一个长度为 n 的数组 nums 里的所有数字都在 0～n-1 的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/shu-zu-zhong-zhong-fu-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yangxvhao
 * @date 2022-12-01 21:14.
 */
public class Topic03 {

    public int findRepeatNumber(int[] nums) {
        int [] result = new int[nums.length];
        for (int num : nums) {
            result[num] +=1;
            if(result[num] > 1){
                return num;
            }
        }
        return nums[0];
    }


    public static void main(String[] args) {
        int [] nums = new int[]{2, 3, 1, 0, 2, 5, 3};
        System.out.println(new Topic03().findRepeatNumber(nums));
    }
}
