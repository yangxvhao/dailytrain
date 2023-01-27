package com.yangxvhao.demo.proxy.offer;

/**
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/que-shi-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yangxvhao
 * @date 2023-01-25 21:34.
 */
public class Topic53to2 {
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (nums[m] != m) {
                j = m - 1;
            } else {
                i = m + 1;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new Topic53to2().missingNumber(new int[]{0,1,3}));
        System.out.println(new Topic53to2().missingNumber(new int[]{0,1,2}));
        System.out.println(new Topic53to2().missingNumber(new int[]{0}));
    }
}
