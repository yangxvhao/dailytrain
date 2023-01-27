package com.yangxvhao.demo.proxy.offer;

/**
 * 统计一个数字在排序数组中出现的次数。
 *
 * @author yangxvhao
 * @date 2023-01-25 20:39.
 */
public class Topic53 {
    /**
     * 二分查找
     *
     * @param nums
     * @param target
     * @return
     */
    public int search(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        // 1 2 3 3 4 4 5 6 7 8 9 target=3
        //右边界
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (target >= nums[m]) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        //没有找到target，提前返回
        if (j > 0 && nums[j] != target) {
            return 0;
        }
        int right = i;
        //左边界,左边界在[0,j]之间，所以只用重置i
        i = 0;
        while (i <= j) {
            int m = i + (j - i) / 2;
            if (target > nums[m]) {
                i = m + 1;
            } else {
                j = m - 1;
            }
        }
        int left = j;
        return right - left - 1;
    }

    public static void main(String[] args) {
        System.out.println(new Topic53().search(new int[]{5,7,7,8,8,10}, 8));
    }
}
