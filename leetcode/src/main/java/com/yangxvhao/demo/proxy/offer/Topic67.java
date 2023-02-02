package com.yangxvhao.demo.proxy.offer;

/**
 * 写一个函数 StrToInt，实现把字符串转换成整数这个功能。不能使用 atoi 或者其他类似的库函数。
 *
 * @author yangxvhao
 * @date 2023-01-31 17:29.
 */
public class Topic67 {
    public int strToInt(String str) {
        int sign = 1, max = Integer.MAX_VALUE / 10;
        int i = 0;
        while (i < str.length() && str.charAt(i) == ' ') {
            i++;
        }
        if (i == str.length()) {
            return 0;
        }
        if (str.charAt(i) == '-') {
            sign = -1;
        }
        if (str.charAt(i) == '-' || str.charAt(i) == '+') {
            i++;
        }
        int ans = 0;
        while (i < str.length() && str.charAt(i) >= '0' && str.charAt(i) <= '9') {
            char c = str.charAt(i);
            if ((ans == max && c > '7') || ans > max) {
                return sign == -1 ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            } else {
                ans = ans * 10 + (c - '0');
            }
            i++;
        }
        return ans * sign;
    }

    public static void main(String[] args) {
//        System.out.println(new Topic67().strToInt("   -42"));
//        System.out.println(new Topic67().strToInt("4193 with words"));
//        System.out.println(new Topic67().strToInt("-91283472332"));
//        System.out.println(new Topic67().strToInt("-+++9"));
        System.out.println(new Topic67().strToInt("   "));
    }
}
