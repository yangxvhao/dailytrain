package com.yangxvhao.demo.proxy.offer;

import java.util.Arrays;

/**
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 * @author yangxvhao
 * @date 2023-01-20 11:25.
 */
public class Topic40 {
    public int[] getLeastNumbers(int[] arr, int k) {
        quickSort(arr, k, 0, arr.length - 1);
        return Arrays.copyOf(arr, k);
    }

    /**
     * 利用快排思想
     *
     * @param arr
     * @param k
     * @param left
     * @param right
     */
    private void quickSort(int[] arr, int k, int left, int right) {
        if (left < right) {
            int pivot = getPivot(arr, left, right);
            if (k == pivot) {
                return;
            }
            //k 小于 枢纽 只需要排左边
            if (k <= pivot) {
                quickSort(arr, k, left, pivot - 1);
            }
            //K 大于 枢纽 只需要排右边
            if (k >= pivot) {
                quickSort(arr, k, pivot + 1, right);
            }
        }
    }

    private int getPivot(int[] arr, int left, int right) {
        // 3 1 4 2 5
        int pivot = arr[left];
        while (left < right) {
            //从右往做扫描，大于枢纽的，继续移动指针
            while (left < right && arr[right] >= pivot) {
                right--;
            }
            // 2 1 4 2 5
            //a[right]小于枢纽，交换
            arr[left] = arr[right];
            //从左往右扫描，大于枢纽的，继续移动指针
            while (left < right && arr[left] <= pivot) {
                left++;
            }
            //2 1 4 4 5
            //a[left]大于枢纽，交换
            arr[right] = arr[left];
        }
        //2 1 3 4 5
        arr[left] = pivot;
        return left;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Topic40().getLeastNumbers(new int[]{4, 5, 1, 6, 2, 7, 3, 8}, 4)));
    }
}
