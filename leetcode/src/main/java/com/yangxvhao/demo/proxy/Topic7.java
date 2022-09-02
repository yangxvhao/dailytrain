package com.yangxvhao.demo.proxy;

/**
 * @author yangxvhao
 * @date 2018-08-08 下午1:49.
 */
public class Topic7 {
    public static void main(String[] args) {
//        int result = reverse(-2147483648);
        int result = reverse(2147483647);
        System.out.println(result);
    }

    public static int reverse(int x) {
        int temp = 0;
        while (x != 0) {
            int y = x % 10;
            x = x / 10;
            if (temp > Integer.MAX_VALUE / 10 || (temp == Integer.MAX_VALUE && y > 7)) return 0;
            if (temp < Integer.MIN_VALUE / 10 || (temp == Integer.MIN_VALUE && y < -8)) return 0;
            temp = y + temp * 10;
        }

        return temp;
    }
}
