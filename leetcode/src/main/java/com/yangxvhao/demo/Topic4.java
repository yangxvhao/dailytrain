package com.yangxvhao.demo;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 *
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 * 
 * @author yangxvhao
 * @date 2018-07-24 下午2:40.
 */
public class Topic4 {
    public static void main(String[] args) {
//        int [] nums1 = {1,3}, nums2 = {2};
        int [] nums1 = {1,2}, nums2 = {3, 4};
        findMedianSortedArrays(nums1, nums2);
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double average = 0;
        int n1 = nums1.length, n2 = nums2.length;
        for (int i : nums1) {
            
        }
        
        return average;
    }
}
