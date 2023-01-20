package com.yangxvhao.demo.proxy.offer;

/**
 * 输入一个整型数组，数组中的一个或连续多个整数组成一个子数组。求所有子数组的和的最大值。
 * <p>
 * 要求时间复杂度为O(n)。
 *
 * @author yangxvhao
 * @date 2023-01-20 14:38.
 */
public class Topic42 {
    public int maxSubArray(int[] nums) {
        return dp(nums);
    }

    /**
     * 动态规划
     * 1.定义状态：dp[i]表示为以nums[i]结尾的子数组的最大和
     * 2.状态转移方程：dp[i]=max(dp[i-1]+nums[i],nums[i])
     * 3.初始值: dp[0]=nums[0]
     * 4.循环:nums
     *
     * @param nums
     * @return
     */
    private int dp(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
//        int[] dp = new int[nums.length];
//        dp[0] = nums[0];
        int tmp = nums[0];

        int maxNum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            tmp = Math.max(tmp + nums[i], nums[i]);
//            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            maxNum = Math.max(maxNum, tmp);
        }
        return maxNum;
    }

    public static void main(String[] args) {
        System.out.println(new Topic42().maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4}));
        System.out.println(new Topic42().maxSubArray(new int[]{-2, -1}));
    }

}
