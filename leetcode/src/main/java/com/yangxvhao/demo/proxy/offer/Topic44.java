package com.yangxvhao.demo.proxy.offer;

/**
 * 数字以0123456789101112131415…的格式序列化到一个字符序列中。在这个序列中，第5位（从下标0开始计数）是5，第13位是1，第19位是4，等等。
 * <p>
 * 请写一个函数，求任意第n位对应的数字。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/shu-zi-xu-lie-zhong-mou-yi-wei-de-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yangxvhao
 * @date 2023-01-20 19:54.
 */
public class Topic44 {
    /**
     * 数学公式推理
     * start
     * digit
     * count
     *
     * @param n
     * @return
     */
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1, count = 9;
        while (n > count) {
            digit = digit + 1;
            n = (int) (n - count);
            start = start * 10;
            count = 9 * start * digit;
        }

        long num = start + (n - 1) / digit;
        return Long.toString(num).charAt((n - 1) % digit) - '0';
    }

    public static void main(String[] args) {
        //01234567891012
        System.out.println(new Topic44().findNthDigit(1000000000));
        System.out.println(new Topic44().findNthDigit(3));
    }
}
