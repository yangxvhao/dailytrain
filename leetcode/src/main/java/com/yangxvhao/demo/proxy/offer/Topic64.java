package com.yangxvhao.demo.proxy.offer;

/**
 * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
 * @author yangxvhao
 * @date 2023-01-30 17:43.
 */
public class Topic64 {
    /**
     * 3种方法：
     * 1.公式法，需要用到乘除法，所以不行
     * 2.迭代，需要用到循环，所以不行
     * 3.递归，递归的终止需要用到if判断语句，所以使用逻辑符短路：
     * A&&B，如果A为false则不执行B，来终止递归
     * A||B，如果A为true则不执行B
     * @param n
     * @return
     */
    int res = 0;
    public int sumNums(int n) {
        boolean b = n > 1 && sumNums(n-1) > 0;
        res = res + n;
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Topic64().sumNums(5));
        System.out.println(new Topic64().sumNums(3));
    }
}
