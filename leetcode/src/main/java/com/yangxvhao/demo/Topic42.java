package com.yangxvhao.demo;

/**
 * 接雨水
 *
 * @author yangxuhao
 * @date 2019-12-03 17:57.
 */
public class Topic42 {
    public static void main(String[] args) {
        int[] h = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(h));
    }

    public static int trap(int[] height) {
        int ans = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int maxLeft = 0;
            for (int j = i; j > 0; j--) {
                maxLeft = Math.max(maxLeft, height[j]);
            }
            int maxRight = 0;
            for (int j = i; j < height.length; j++) {
                maxRight = Math.max(maxRight, height[j]);
            }
            ans += Math.min(maxLeft, maxRight) - height[i];
        }

        return ans;
    }
}
