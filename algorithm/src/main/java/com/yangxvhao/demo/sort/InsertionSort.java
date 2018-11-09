package com.yangxvhao.demo.sort;

import com.yangxvhao.demo.BaseSort;

/**
 * 插入排序
 * 算法描述：
 * 从第一个元素开始，该元素可以认为已经被排序；
 * 取出下一个元素，在已经排序的元素序列中从后向前扫描；
 * 如果该元素（已排序）大于新元素，将该元素移到下一位置；
 * 重复步骤3，直到找到已排序的元素小于或者等于新元素的位置；
 * 将新元素插入到该位置后；
 * 重复步骤2~5
 *
 * @author yangxvhao
 * @date 2018-11-05 上午11:42.
 */
public class InsertionSort extends BaseSort {
    @Override
    public Integer[] sort(Integer... param) {
        for (int i = 1; i < param.length; i++) {
            int cur = param[i];
            int j = i - 1;
            for (; j >= 0; j--) {
                if (cur < param[j]) {
                    param[j + 1] = param[j];
                } else {
                    break;
                }
            }
            param[j + 1] = cur;
        }
        return param;
    }
}
