package com.yangxvhao.demo.proxy.offer;

/**
 * 写一个函数，求两个整数之和，要求在函数体内不得使用 “+”、“-”、“*”、“/” 四则运算符号。
 *
 * @author yangxvhao
 * @date 2023-01-30 18:07.
 */
public class Topic65 {
    /**
     * 无进位求和 == 异或操作： 1+2=1^2
     * 有进位求和 == 与操作+左移一位： 8+4=8&4<<1
     *
     * @param a
     * @param b
     * @return
     */
    public int add(int a, int b) {
        int sum = a ^ b;
        int carry = (a & b) << 1;
        while (carry != 0) {
            a = sum;
            b = carry;
            sum = a ^ b;
            carry = (a & b) << 1;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Topic65().add(1, 2));
        System.out.println(new Topic65().add(7, 5));
    }
}
