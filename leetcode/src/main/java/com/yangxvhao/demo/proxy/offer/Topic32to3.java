package com.yangxvhao.demo.proxy.offer;

import java.util.*;

/**
 * 请实现一个函数按照之字形顺序打印二叉树，即第一行按照从左到右的顺序打印，第二层按照从右到左的顺序打印，第三行再按照从左到右的顺序打印，其他行以此类推。
 *
 * @author yangxvhao
 * @date 2022-12-24 21:02.
 */
public class Topic32to3 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return new ArrayList<>();
        }
        Queue<TreeNode> queue = new ArrayDeque<>();
        List<List<Integer>> res = new ArrayList<>();

        queue.offer(root);
        int level = 0;
        while (queue.size() > 0) {
            LinkedList<Integer> tmp = new LinkedList<>();
            for (int i = queue.size(); i > 0; i--) {
                TreeNode node = queue.poll();
                if(level %2==0){
                    tmp.add(node.val);
                }else {
                    tmp.addFirst(node.val);
                }

                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            level++;
            res.add(tmp);
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

        System.out.println(new Topic32to3().levelOrder(node));
    }

}
