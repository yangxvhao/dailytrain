package com.yangxvhao.demo.proxy.sort;

import com.yangxvhao.demo.proxy.BaseSort;

/**
 * @author yangxvhao
 * @date 2018-11-08 下午1:02.
 */
public class QuickSort extends BaseSort {
    @Override
    public Integer[] sort(Integer... param) {
        return qsort(param, 0, param.length - 1);
    }

    private static Integer[] qsort(Integer[] arr, int low, int high) {
        if (low < high) {
            int pivot = partition(arr, low, high);        //将数组分为两部分
            qsort(arr, low, pivot - 1);                   //递归排序左子数组
            qsort(arr, pivot + 1, high);                  //递归排序右子数组
        }
        return arr;
    }

    private static int partition(Integer[] arr, int low, int high) {
        int pivot = arr[low];     //枢轴记录
        while (low < high) {
            while (low < high && arr[high] >= pivot) --high;
            arr[low] = arr[high];             //交换比枢轴小的记录到左端
            while (low < high && arr[low] <= pivot) ++low;
            arr[high] = arr[low];           //交换比枢轴小的记录到右端
        }
        //扫描完成，枢轴到位
        arr[low] = pivot;
        //返回的是枢轴的位置
        return low;
    }
}
