package com.yangxvhao.demo.proxy.offer;

/**
 * 给定一个数字，我们按照如下规则把它翻译为字符串：0 翻译成 “a” ，1 翻译成 “b”，……，11 翻译成 “l”，……，25 翻译成 “z”。
 * 一个数字可能有多个翻译。请编程实现一个函数，用来计算一个数字有多少种不同的翻译方法。
 * <p>
 *  
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yangxvhao
 * @date 2023-01-24 13:38.
 */
public class Topic46 {
    public int translateNum(int num) {
        //12258
//        return dp1(num);
//        return dp2(num);
        return dp3(num);
    }

    /**
     * 标准dp
     *
     * @param num
     * @return
     */
    private int dp1(int num) {
        String numStr = String.valueOf(num);
        int[] dp = new int[numStr.length() + 1];
        dp[0] = 1;
        dp[1] = 1;
        char[] numChar = numStr.toCharArray();
        for (int i = 2; i <= numChar.length; i++) {
            int tmp = Integer.parseInt(numChar[i - 2] + String.valueOf(numChar[i - 1]));
            if (tmp > 25 || tmp < 10) {
                dp[i] = dp[i - 1];
            } else {
                dp[i] = dp[i - 1] + dp[i - 2];
            }
        }
        return dp[numChar.length - 1];
    }

    /**
     * 只依赖dp[i-1],dp[i-2],优化dp空间
     *
     * @param num
     * @return
     */
    private int dp2(int num) {
        String numStr = String.valueOf(num);

        int a = 1, b = 1, c = 0;
        //dp[0] = 1;
        //dp[1] = 1;
        char[] numChar = numStr.toCharArray();
        for (int i = 2; i <= numChar.length; i++) {
            int tmp = Integer.parseInt(numChar[i - 2] + String.valueOf(numChar[i - 1]));
            if (tmp > 25 || tmp < 10) {
                c = b;
                //dp[i] = dp[i - 1];
            } else {
                c = a + b;
                //dp[i] = dp[i - 1] + dp[i - 2];
            }
            a = b;
            b = c;
        }
        return b;
    }

    /**
     * 优化转string辅助空间
     *
     * @param num
     * @return
     */
    private int dp3(int num) {
        //12258
        int a = 1, b = 1, c = 0;
        while (num > 9) {
            c = num % 100 > 25 || num % 100 < 10 ? b : a + b;
            a = b;
            b = c;
            num = num / 10;
        }
        return b;
    }

    public static void main(String[] args) {
        System.out.println(new Topic46().translateNum(624));
    }
}
