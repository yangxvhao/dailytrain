package com.yangxvhao.demo.proxy.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 输入某二叉树的前序遍历和中序遍历的结果，请构建该二叉树并返回其根节点。
 * <p>
 * 假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 *
 * @author yangxvhao
 * @date 2022-12-02 12:29.
 */
public class Topic07 {

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    Map<Integer, Integer> map = new HashMap<>();
    int[] preorder;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        this.preorder = preorder;
        return recur(0, 0, inorder.length-1);
    }

    public TreeNode recur(int root_idx, int left_idx, int right_idx) {
        if (left_idx > right_idx) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[root_idx]);
        int idx = map.get(preorder[root_idx]);
        root.left = recur(root_idx + 1, left_idx, idx - 1);
        root.right = recur(root_idx + idx - left_idx + 1, idx + 1, right_idx);
        return root;
    }


    public static void main(String[] args) {
        int[] preorder = new int[]{3, 9, 20, 15, 7}, inorder = {9, 3, 15, 20, 7};
        TreeNode treeNode = new Topic07().buildTree(preorder, inorder);
        System.out.println();
    }
}
