package com.yangxvhao.demo;

/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2 。
 * <p>
 * 请找出这两个有序数组的中位数。要求算法的时间复杂度为 O(log (m+n)) 。
 *
 * @author yangxvhao
 * @date 2018-07-24 下午2:40.
 */
public class Topic4 {
    public static void main(String[] args) {
        int [] nums1 = {1,3}, nums2 = {2};
//        int[] nums1 = {5, 6, 7, 8}, nums2 = {1, 2, 3, 4};
//        System.out.println(findMedianSortedArrays(nums1, nums2));
        System.out.println(findMedianSortedArrays2(nums1, nums2));
    }

    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double average = 0;
        int n1 = nums1.length, n2 = nums2.length;
        //做转换,保证j不为负数
        if (n1 > n2) {
            int temp = n1;
            n1 = n2;
            n2 = temp;
            int[] num = nums1;
            nums1 = nums2;
            nums2 = num;
        }
        //使用二分查找
        int iMin = 0, iMax = n1;
        int i = 0, j = 0;
        while (iMin <= iMax) {
            i = (iMin + iMax) / 2;
            j = (n1 + n2 + 1) / 2 - i;
            //说明i太大,缩小范围[iMin,iMax-1]
            if (i > iMin && nums1[i - 1] > nums2[j]) {
                iMax = iMax - 1;
            }
            //说明i太小,缩小范围[iMin+1,iMax]
            else if (i < iMax && nums2[j - 1] > nums1[i]) {
                iMin = iMin + 1;
            }
            //满足nums1[i-1]<=nums2[j] && nums2[j-1]<=nums1[i],找到了合适的i
            else {
                int leftMax = 0;
                if (i == 0) {
                    leftMax = nums2[j - 1];
                } else if (j == 0) {
                    leftMax = nums1[i - 1];
                } else {
                    leftMax = Math.max(nums1[i - 1], nums2[j - 1]);
                }
                //n1+n2为奇数,中位数=
                if ((n1 + n2) % 2 == 1) {
                    return leftMax;
                }

                int rightMin = 0;
                if (i == n1) {
                    rightMin = nums2[j];
                } else if (j == n2) {
                    rightMin = nums1[i];
                } else {
                    rightMin = Math.min(nums1[i], nums2[j]);
                }
                return (leftMax + rightMin) / 2.0;
            }
        }
        return average;
    }
    
    public static double findMedianSortedArrays2(int nums1[], int nums2[]){
        // 创建一个新数组，存储两个数组中的数据
        int length = nums1.length + nums2.length;
        int[] newArr = new int[length];
        int minLength = nums1.length > nums2.length ? nums2.length : nums1.length;
        int j = 0;
        int k = 0;
        int i = 0;
        for (i = 0; (j < nums1.length && k < nums2.length) ; i++) {
            if (nums1[j] >= nums2[k]) {
                newArr[i] = nums2[k];
                k++;
            } else {
                newArr[i] = nums1[j];
                j++;
            }
        }
        // 将剩余的数据放入新建立的数组中
        while (j < nums1.length) {
            newArr[i ++] = nums1[j++];
        }
        while (k < nums2.length) {
            newArr[i ++] = nums2[k++];
        }
        if (length % 2 == 0) {
            return ((double) newArr[length / 2] + newArr[length / 2 - 1]) / 2;
        } else {
            return (double) newArr[length / 2];
        }
    }
}
