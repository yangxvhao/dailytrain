package com.yangxvhao.demo.proxy;

/**
 * @author yangx
 * @date 2019-12-12 10:32.
 */
public class Topic121 {
    public static void main(String[] args) {
        int[] nums = {7,6,4,3,8};
        System.out.println(maxProfit(nums));
    }

    public static int maxProfit(int[] prices){
        if(prices.length < 1){
            return 0;
        }
        int maxProfit = 0;
        int minNum = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if(maxProfit < (prices[i] - minNum)){
                maxProfit = prices[i] - minNum;
            }
            if(minNum > prices[i]){
                minNum = prices[i];
            }

        }
        return maxProfit;
    }
}
