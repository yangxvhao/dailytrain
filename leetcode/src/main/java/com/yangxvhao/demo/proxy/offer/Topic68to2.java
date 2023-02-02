package com.yangxvhao.demo.proxy.offer;

import com.yangxvhao.demo.proxy.ListNodeUtil.TreeNode;

/**
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * @author yangxvhao
 * @date 2023-01-31 11:44.
 */
public class Topic68to2 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null)
            return null;
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left == null && right == null) {
            return null;
        }
        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode left1 = new TreeNode(2, new TreeNode(7), new TreeNode(4));
        TreeNode left = new TreeNode(5, new TreeNode(6), left1);
        TreeNode right = new TreeNode(1, new TreeNode(0), new TreeNode(8));
        TreeNode root = new TreeNode(3, left, right);
        System.out.println(new Topic68to2().lowestCommonAncestor(root, left, right).val);
    }
}
