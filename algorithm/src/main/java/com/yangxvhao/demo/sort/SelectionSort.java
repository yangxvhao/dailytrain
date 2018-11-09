package com.yangxvhao.demo.sort;

import com.yangxvhao.demo.BaseSort;

/**
 * 选择排序
 * 算法描述
 * 初始状态：无序区为R[1..n]，有序区为空；
 * 第i趟排序(i=1,2,3…n-1)开始时，当前有序区和无序区分别为R[1..i-1]和R(i..n）。该趟排序从当前无序区中-选出关键字最小的记录 R[k]，
 * 将它与无序区的第1个记录R交换，使R[1..i]和R[i+1..n)分别变为记录个数增加1个的新有序区和记录个数减少1个的新无序区；
 * n-1趟结束，数组有序化了
 *
 * @author yangxvhao
 * @date 2018-11-05 上午10:50.
 */
public class SelectionSort extends BaseSort {

    @Override
    public Integer[] sort(Integer... param) {
        for (int i = 0; i < param.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < param.length; j++) {
                if (param[j] < param[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = param[i];
            param[i] = param[minIndex];
            param[minIndex] = temp;
        }
        return param;
    }
}
