package com.yangxvhao.demo.proxy.offer;

import java.util.Arrays;

/**
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 * 全排列
 * @author yangxvhao
 * @date 2022-12-04 21:12.
 */
public class Topic17 {
    int[] res;
    int count = 0;
    char[] nums = new char[]{'0','1','2','3','4','5','6','7','8','9'};
    public int[] printNumbers(int n) {
        res = new int[(int) (Math.pow(10, n) -1)];

        for (int i = 1; i < n+1; i++) {
            for (int j = 1; j < nums.length; j++) {
                char[] chars = new char[i];
                chars[0] = nums[j];
                dfs(1, chars, i);
            }
        }
        return res;
    }

    public void dfs(int index, char[] chars, int i){
        if(index == i){
            res[count++] = Integer.parseInt(String.valueOf(chars));
            return;
        }
        for (int j = 0; j < nums.length; j++) {
            chars[index] = nums[j];
            dfs(index + 1, chars,i);
        }
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Topic17().printNumbers(3)));
    }
}
