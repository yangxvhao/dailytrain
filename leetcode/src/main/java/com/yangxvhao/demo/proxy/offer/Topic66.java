package com.yangxvhao.demo.proxy.offer;

import java.util.Arrays;

/**
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积,
 * 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/gou-jian-cheng-ji-shu-zu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yangxvhao
 * @date 2023-01-30 20:56.
 */
public class Topic66 {
    /**
     * 不能使用除法
     * 考虑B[i]=A[i]左边的乘积*A[i]右边的乘积
     * 维护2个数组分别记录即可
     *
     * @param a
     * @return
     */
    public int[] constructArr(int[] a) {
        int[] left = new int[a.length];
        int[] right = new int[a.length];
        left[0] = right[a.length - 1] = 1;
        //左边的乘积
        for (int i = 1; i < a.length; i++) {
            left[i] = left[i - 1] * a[i - 1];
        }
        //右边的乘积
        for (int i = a.length - 2; i >= 0; i--) {
            right[i] = right[i + 1] * a[i + 1];
        }

        int[] ans = new int[a.length];
        for (int i = 0; i < a.length; i++) {
            ans[i] = left[i] * right[i];
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Topic66().constructArr(new int[]{1, 2, 3, 4, 5})));
    }
}
