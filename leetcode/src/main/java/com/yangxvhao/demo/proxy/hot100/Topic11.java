package com.yangxvhao.demo.proxy.hot100;

/**
 * 给定一个长度为 n 的整数数组 height 。有 n 条垂线，第 i 条线的两个端点是 (i, 0) 和 (i, height[i]) 。
 * <p>
 * 找出其中的两条线，使得它们与 x 轴共同构成的容器可以容纳最多的水。
 * <p>
 * 返回容器可以储存的最大水量。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/container-with-most-water
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yangxvhao
 * @date 2023-02-02 20:01.
 */
public class Topic11 {
    /**
     * 双指针
     * 循环每次移动2个指针中较短的那一个，即可得到最大面积
     * 证明:面积=长*高
     * 移动2个指针中任一个，长度都会-1，
     * 移动较短的一个，高度有可能会变大，从而面积也会变大
     * 移动较长的那个，高度不可能变大，从而面积也不会变大，只会减小
     *
     * @param height
     * @return
     */
    public int maxArea(int[] height) {
        int left = 0, right = height.length - 1, res = 0;
        while (left < right) {
            int l = right - left;
            int h = height[left] > height[right] ? height[right--] : height[left++];
            res = Math.max(res, l * h);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Topic11().maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
