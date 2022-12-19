package com.yangxvhao.demo.proxy.offer;

/**
 * 请完成一个函数，输入一个二叉树，该函数输出它的镜像。
 *
 * @author yangxvhao
 * @date 2022-12-13 21:36.
 */
public class Topic27 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode tmp = root.left;
        root.left = mirrorTree(root.right);
        root.right = mirrorTree(tmp);
        return root;    
    }

    public static void main(String[] args) {

    }
}
