package com.yangxvhao.demo.proxy.offer;

/**
 * 请实现一个函数，用来判断一棵二叉树是不是对称的。如果一棵二叉树和它的镜像一样，那么它是对称的。
 *
 * @author yangxvhao
 * @date 2022-12-19 21:19.
 */
public class Topic28 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        return recur(root.left, root.right);
    }

    private boolean recur(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null || left.val != right.val) {
            return false;
        }

        return recur(left.left, right.right) && recur(left.right, right.left);
    }

    public static void main(String[] args) {
        //root = [1,2,2,3,4,4,3]
        TreeNode root = new TreeNode(1);
        TreeNode left = new TreeNode(2);
        TreeNode right = new TreeNode(2);
        root.left = left;
        root.right = right;

        left.left = new TreeNode(3);
        left.right = new TreeNode(4);

        right.left = new TreeNode(4);
        right.right = new TreeNode(3);
        System.out.println(new Topic28().isSymmetric(root));
    }
}
