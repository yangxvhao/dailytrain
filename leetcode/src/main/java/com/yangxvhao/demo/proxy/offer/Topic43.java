package com.yangxvhao.demo.proxy.offer;

/**
 * 输入一个整数 n ，求1～n这n个整数的十进制表示中1出现的次数。
 * <p>
 * 例如，输入12，1～12这些整数中包含1 的数字有1、10、11和12，1一共出现了5次。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/1nzheng-shu-zhong-1chu-xian-de-ci-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yangxvhao
 * @date 2023-01-20 16:36.
 */
public class Topic43 {
    public int countDigitOne(int n) {
        return methodOpt(n);
    }

    /**
     * 数学公式法:将数字分为3部分
     * (1 2 3) 0  (4)
     * high   cur low,digit=10^i
     * cur=0：high*digit
     * cur=1: high*digit+low+1
     * cur>1: high*digit+digit
     *
     * @param n
     * @return
     */
    private int methodOpt(int n) {
        int res = 0, digit = 1;
        int low = 0, high = n / 10, cur = n % 10;

        while (high != 0 || cur != 0) {
            if (cur == 0) {
                res = res + high * digit;
            } else if (cur == 1) {
                res = res + high * digit + low + 1;
            } else {
                res = res + high * digit + digit;
            }

            low = low + cur * digit;
            cur = high % 10;
            high = high / 10;
            digit = digit * 10;
        }
        return res;
    }

    /**
     * 能想到的暴力解法
     *
     * @param n
     * @return
     */
    private int method1(int n) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 1; i <= n; i++) {
            stringBuilder.append(i);
        }
        char[] charArray = stringBuilder.toString().toCharArray();
        int count = 0;
        for (char c : charArray) {
            if (c == '1') {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new Topic43().countDigitOne(12));
        System.out.println(new Topic43().countDigitOne(13));
    }
}
