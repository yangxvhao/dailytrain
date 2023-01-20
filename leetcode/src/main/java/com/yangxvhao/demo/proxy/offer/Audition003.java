package com.yangxvhao.demo.proxy.offer;

/**
 * 蚂蚁数字科技线一面
 * 给定一个数组，数组由数组元素组成的最大数
 *
 * @author yangxvhao
 * @date 2023-01-06 12:10.
 */
public class Audition003 {
    public static void main(String[] args) {
        int[] array = new int[]{45, 7, 9};
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                int num1 = Integer.parseInt(array[i] + String.valueOf(array[j]));
                int num2 = Integer.parseInt(array[j] + String.valueOf(array[i]));
                if (num1 < num2) {
                    int tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            stringBuilder.append(array[i]);
        }
        System.out.println(stringBuilder.toString());
    }
}
