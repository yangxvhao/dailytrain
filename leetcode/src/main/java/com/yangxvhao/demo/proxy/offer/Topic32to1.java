package com.yangxvhao.demo.proxy.offer;

import java.util.*;

/**
 * 从上到下打印出二叉树的每个节点，同一层的节点按照从左到右的顺序打印。
 *
 * @author yangxvhao
 * @date 2022-12-23 17:30.
 */
public class Topic32to1 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public int[] levelOrder(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> resList = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while (queue.size() > 0) {
            TreeNode node = queue.poll();
            resList.add(node.val);
            if (node.right != null) {
                queue.offer(node.right);
            }
            if (node.left != null) {
                queue.offer(node.left);
            }

        }
        int[] res = new int[resList.size()];
        for (int i = 0; i < resList.size(); i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode node = new TreeNode(3);
        node.right = new TreeNode(9);

        TreeNode left = new TreeNode(20);
        node.left = left;
        left.right = new TreeNode(15);
        left.left = new TreeNode(7);

        System.out.println(Arrays.toString(new Topic32to1().levelOrder(node)));
    }
}
