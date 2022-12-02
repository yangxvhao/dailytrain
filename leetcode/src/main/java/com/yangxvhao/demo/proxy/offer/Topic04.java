package com.yangxvhao.demo.proxy.offer;

/**
 * 在一个 n * m 的二维数组中，每一行都按照从左到右 非递减 的顺序排序，每一列都按照从上到下 非递减 的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yangxvhao
 * @date 2022-12-01 21:31.
 */
public class Topic04 {

    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                if (anInt == target) {
                    return true;
                } else if (target < anInt) {
                    break;
                } else if (target < ints[0]) {
                    return false;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] matix = new int[][]{
                {1, 4, 7, 11, 15},
                {2, 5, 8, 12, 19},
                {10, 13, 14, 17, 24}

        };
        System.out.println(new Topic04().findNumberIn2DArray(matix, 3));
    }
}
