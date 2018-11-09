package com.yangxvhao.demo.sort;

import com.yangxvhao.demo.BaseSort;

/**
 * 冒泡排序
 * 算法描述：
 * 比较相邻的元素。如果第一个比第二个大，就交换它们两个；
 * 对每一对相邻元素作同样的工作，从开始第一对到结尾的最后一对，这样在最后的元素应该会是最大的数；
 * 针对所有的元素重复以上的步骤，除了最后一个；
 * 重复步骤1~3，直到排序完成。
 *
 * @author yangxvhao
 * @date 2018-11-05 上午10:46.
 */
public class BubbleSort extends BaseSort {
    
    @Override
    public Integer[] sort(Integer... param) {
        for (int i = 0; i < param.length - 1; i++) {
            for (int j = 0; j < param.length - 1 - i; j++) {
                if (param[j] > param[j + 1]) {
                    int temp = param[j];
                    param[j] = param[j + 1];
                    param[j + 1] = temp;
                }
            }
        }

        return param;
    }
}
