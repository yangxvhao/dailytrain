package com.yangxvhao.demo.structuralpattern.adapterpattern.scoreoperation;

/**
 * 适配者
 * @author yangxvhao
 * @date 18-1-19.
 */

public class BinarySearch {
    /**
     * 二分查找，基于有序数组
     * @param nums
     * @param num
     * @return
     */
    public int binarySearch(int[] nums, int num){
        int start = 0;
        int end = nums.length - 1;
        while (start <= end){
            int mid = (start + end)/2;
            int midVal = nums[mid];
            if(midVal < num)
            {
                start = mid + 1;
            }else if(midVal > num){
                end = mid - 1;
            }else if(midVal == num){
                return 1;
            }
        }
        return -1;
    }
}
