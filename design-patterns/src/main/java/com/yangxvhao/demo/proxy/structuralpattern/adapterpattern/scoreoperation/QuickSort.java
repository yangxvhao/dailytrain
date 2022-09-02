package com.yangxvhao.demo.proxy.structuralpattern.adapterpattern.scoreoperation;

/**
 * 适配者
 * @author yangxvhao
 * @date 18-1-19.
 */

public class QuickSort {
    /**
     * 快速排序
     * @param nums
     */
    public void quickSort(int [] nums){
        System.out.println("排序前：");disPlay(nums);
        sort(nums, 0, nums.length-1);
        System.out.println("排序后：");disPlay(nums);
    }

    private void sort(int[] nums, int start, int end){
        int tmp = 0;
        if(start < end){
            tmp = partition(nums, start, end);
            sort(nums, start, tmp-1);
            sort(nums, tmp+1, end);
        }
    }

    private int partition(int[] array, int start, int end){
        int x = array[end];
        int j = start - 1;
        for (int i = start; i <= (end -1); i ++){
            if(array[i] < x){
                j ++;
                swap(array, j, i);
            }
        }
        swap(array, j+1, end);
        return j+1;
    }

    private void swap(int [] array, int i, int j){
        int temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    private void disPlay(int [] nums){
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[");
        for (int num : nums) {
            stringBuilder.append(num + ",");
        }
        stringBuilder.append("]");
        System.out.println(stringBuilder);
    }
}
