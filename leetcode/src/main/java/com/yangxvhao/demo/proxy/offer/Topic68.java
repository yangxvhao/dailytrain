package com.yangxvhao.demo.proxy.offer;

import com.yangxvhao.demo.proxy.ListNodeUtil.TreeNode;

/**
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * @author yangxvhao
 * @date 2023-01-30 22:13.
 */
public class Topic68 {
    /**
     * 二叉搜索树性质：
     * 左子树<根<右子树
     *
     * @param root
     * @param p
     * @param q
     * @return
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //p,q都大于根，说明都在右子树
        if (p.val > root.val && q.val > root.val) {
            return lowestCommonAncestor(root.right, p, q);
        }
        if (p.val < root.val && q.val < root.val) {
            return lowestCommonAncestor(root.left, p, q);
        }
        return root;
    }

    public static void main(String[] args) {
        TreeNode left1 = new TreeNode(4, new TreeNode(3), new TreeNode(5));
        TreeNode left = new TreeNode(2, new TreeNode(0), left1);
        TreeNode right = new TreeNode(8, new TreeNode(7), new TreeNode(9));
        TreeNode root = new TreeNode(6, left, right);
        System.out.println(new Topic68().lowestCommonAncestor(root, new TreeNode(2), new TreeNode(8)).val);
    }
}
