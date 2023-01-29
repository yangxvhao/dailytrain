package com.yangxvhao.demo.proxy.offer;

import com.yangxvhao.demo.proxy.ListNodeUtil;
import com.yangxvhao.demo.proxy.ListNodeUtil.TreeNode;

/**
 * 给定一棵二叉搜索树，请找出其中第 k 大的节点的值。
 *
 * @author yangxvhao
 * @date 2023-01-27 13:58.
 */
public class Topic54 {
    int count = 1;
    int res = 0;

    /**
     * 二叉搜索树的中序遍历是递增的，利用这个特性
     *
     * @param root
     * @param k
     * @return
     */
    public int kthLargest(TreeNode root, int k) {
        this.count = k;
        recur(root);
        return res;
    }

    public void recur(TreeNode root) {
        if (root == null || count == 0) {
            return;
        }
        recur(root.right);
        if (--count == 0) {
            res = root.val;
            return;
        }
        recur(root.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2,
                                new TreeNode(1)),
                        new TreeNode(4)),
                new TreeNode(6));
        System.out.println(new Topic54().kthLargest(root, 3));
    }
}
