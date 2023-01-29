package com.yangxvhao.demo.proxy.offer;

import com.yangxvhao.demo.proxy.ListNodeUtil.TreeNode;

/**
 * @author yangxvhao
 * @date 2023-01-27 16:38.
 */
public class Topic55to1 {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5,
                new TreeNode(3,
                        new TreeNode(2,
                                new TreeNode(1)),
                        new TreeNode(4)),
                new TreeNode(6));
        System.out.println(new Topic55to1().maxDepth(root));
    }
}
