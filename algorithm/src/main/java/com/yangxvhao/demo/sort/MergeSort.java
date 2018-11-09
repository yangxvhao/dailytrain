package com.yangxvhao.demo.sort;

import com.yangxvhao.demo.BaseSort;

/**
 * 归并排序
 * 算法描述：
 * 把长度为n的输入序列分成两个长度为n/2的子序列；
 * 对这两个子序列分别采用归并排序；
 * 将两个排序好的子序列合并成一个最终的排序序列。
 *
 * @author yangxvhao
 * @date 2018-11-05 下午3:10.
 */
public class MergeSort extends BaseSort {
    @Override
    public Integer[] sort(Integer... param) {
        if (param.length < 2) {
            return param;
        }
        Integer[] result = new Integer[param.length + 1];
        split(param, 0, param.length - 1, result);
        return param;
    }

    private Integer[] split(Integer[] array, int first, int last, Integer[] result) {
        int middle = (first + last) / 2;
        if (first < last) {
            split(array, first, middle, result);
            split(array, middle + 1, last, result);
            merge(array, first, middle, last, result);
        }
        return result;
    }

    /**
     * 合并两个有序元组array[first,middle], array[middle+1,last]
     *
     * @param array
     * @param first
     * @param middle
     * @param last
     * @return
     */
    private Integer[] merge(Integer[] array, int first, int middle, int last, Integer[] result) {
        int i = first;
        int j = middle + 1;
        int m = middle;
        int n = last;
        int k = 0;

        while (i <= m && j <= n) {
            if (array[i] <= array[j]) {
                result[k] = array[i];
                i++;
            } else {
                result[k] = array[j];
                j++;
            }
            k++;
        }

        while (i <= m) {
            result[k] = array[i];
            k++;
            i++;
        }

        while ((j <= n)) {
            result[k] = array[j];
            k++;
            j++;
        }

        for (int ii = 0; ii < k; ii++) {
            array[first + ii] = result[ii];
        }

        return array;
    }
}
