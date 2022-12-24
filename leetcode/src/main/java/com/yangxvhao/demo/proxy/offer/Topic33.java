package com.yangxvhao.demo.proxy.offer;

/**
 * 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 *
 * @author yangxvhao
 * @date 2022-12-24 21:13.
 */
public class Topic33 {
    public boolean verifyPostorder(int[] postorder) {
        if (postorder == null || postorder.length == 1) {
            return true;
        }
        return help(postorder, 0, postorder.length - 1);

    }

    public boolean help(int[] postorder, int left, int right) {
        if (left >= right) {
            return true;
        }
        int p = left;
        while (postorder[p] < postorder[right]) {
            p++;
        }
        int m = p;
        while (postorder[p] > postorder[right]) {
            p++;
        }
        return p == right && help(postorder, left, m - 1) && help(postorder, m, right - 1);
    }

    public static void main(String[] args) {
        int[] postorder = new int[]{1, 3, 2, 6, 5};
        System.out.println(new Topic33().verifyPostorder(postorder));
    }
}
