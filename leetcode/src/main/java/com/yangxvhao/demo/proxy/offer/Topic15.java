package com.yangxvhao.demo.proxy.offer;

/**
 * 编写一个函数，输入是一个无符号整数（以二进制串的形式），返回其二进制表达式中数字位数为 '1' 的个数（也被称为 汉明重量).）。
 * @author yangxvhao
 * @date 2022-12-04 18:04.
 */
public class Topic15 {
    public int hammingWeight(int n) {
        int i =0;
        while (n != 0){
            i++;
            n = n & (n-1);
        }
        return i;
    }

    public static void main(String[] args) {
        System.out.println(new Topic15().hammingWeight(11));
        System.out.println(new Topic15().hammingWeight(128));
        System.out.println(new Topic15().hammingWeight(-3));
    }
}
