package com.yangxvhao.demo.proxy;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 二叉树层次遍历
 *
 * @author yangxuhao
 * @date 2019-12-03 16:01.
 */
public class Topic102 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);

        TreeNode left1 = new TreeNode(2);
        TreeNode right1 = new TreeNode(3);

        root.left = left1;
        root.right = right1;

        TreeNode left2 = new TreeNode(4);
        TreeNode right2 = new TreeNode(5);

        left1.left = left2;
        left1.right = right2;

        List<List<Integer>> lists = levelOrder(root);
        System.out.println(lists);
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> lists = new ArrayList<>();
        if (root == null) {
            return lists;
        }
        LinkedList<TreeNode> linkedList = new LinkedList<>();
        linkedList.offer(root);
        while (!linkedList.isEmpty()) {
            List<Integer> list = new ArrayList<>();
            int size = linkedList.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = linkedList.poll();
                if (node == null) {
                    break;
                }

                list.add(node.val);

                if (node.left != null) {
                    linkedList.add(node.left);
                }
                if (node.right != null) {
                    linkedList.add(node.right);
                }
            }


            lists.add(list);
        }
        return lists;
    }
}
