package com.yangxvhao.demo.proxy.offer;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 * @author yangxvhao
 * @date 2023-01-25 15:58.
 */
public class Topic51 {
    int count = 0;

    public int reversePairs(int[] nums) {
//        return method1(nums);
        return method2(nums);
    }

    /**
     * 暴力遍历
     *
     * @param nums
     * @return
     */
    private int method1(int[] nums) {
        int count = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    count++;
                }
            }
        }
        return count;
    }

    /**
     * 利用归并排序
     *
     * @param nums
     * @return
     */
    private int method2(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return count;
    }

    private void mergeSort(int[] nums, int first, int last) {
        if (first >= last) {
            return;
        }
        int middle = (first + last) / 2;
        mergeSort(nums, first, middle);
        mergeSort(nums, middle + 1, last);
        merge(nums, first, middle, last);
    }

    private void merge(int[] nums, int first, int middle, int last) {
        //3 4 5 6     7 8 9 10
        int i = first, j = middle + 1; // 左右两个数组的遍历指针
        int m = middle, n = last; // 左右两个数组的边界
        int k = 0; //临时数组的遍历指针
        int[] tmp = new int[last - first + 1]; // 临时数组，保存两个数组的合并结果
        //3 4 5 6     7 8 9 10
        while (i <= m && j <= n) {
            if (nums[i] <= nums[j]) {
                tmp[k] = nums[i];
                i++;
            } else {
                //统计逆序对
                count = count + middle - i + 1;
                tmp[k] = nums[j];
                j++;
            }
            k++;
        }
        //2 3 4 5 6     7 8 9 10 左边数组 没有遍历完，直接插入到后面
        while (i <= m) {
            tmp[k] = nums[i];
            k++;
            i++;
        }
        //3 4 5 6     7 8 9 10 11 右边数组 没有遍历完，直接插入到后面
        while (j <= n) {
            tmp[k] = nums[j];
            k++;
            j++;
        }
        //把排好序的临时数组 覆盖原数组
        for (int l = 0; l < tmp.length; l++) {
            nums[first + l] = tmp[l];
        }
    }

    public static void main(String[] args) {
//        System.out.println(new Topic51().reversePairs(new int[]{7, 5, 6, 4}));
        System.out.println(new Topic51().reversePairs(new int[]{1, 3, 2, 3, 1}));
    }
}
