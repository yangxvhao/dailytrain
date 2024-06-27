package com.yangxvhao.demo.proxy.tree;

import java.util.LinkedList;
import java.util.List;

import com.yangxvhao.demo.proxy.ListNodeUtil;
import com.yangxvhao.demo.proxy.ListNodeUtil.TreeNode;

/**
 * @author yangxuhao <yangxuhao@kuaishou.com>
 * Created on 2023-12-27
 */
public class TreeNodeShow {
    public static void main(String[] args) {
        /**
         *
         *        1
         *      2   5
         *    3  4 6 7
         *            8
         */
        int[] nums = new int[] {1, 2, 3, 4, 5, 6, 7, 8};
        TreeNode root = ListNodeUtil.buildRootFromArray(nums);
//        List<Integer> list = new ArrayList<>();
//        preOrder(root, list);
//        System.out.println(list);
//        list = new ArrayList<>();
//        inOrder(root, list);
//        System.out.println(list);
//        list = new ArrayList<>();
//        postOrder(root, list);
//        System.out.println(list);
//        list = new ArrayList<>();
//        preOrderIterate(root, list);
//        System.out.println(list);
//        list = new ArrayList<>();
//        levelOrder(root, list);
//        System.out.println(list);
        change(root);
        System.out.println(root);
    }

    public static void preOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        preOrder(root.left, list);
        preOrder(root.right, list);
    }

    public static void inOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        inOrder(root.left, list);
        list.add(root.val);
        inOrder(root.right, list);
    }

    public static void postOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        postOrder(root.left, list);
        postOrder(root.right, list);
        list.add(root.val);
    }

    public static void preOrderIterate(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode tmp = root;
        while (tmp != null || !queue.isEmpty()) {
            while (tmp != null) {
                list.add(tmp.val);
                queue.add(tmp);
                tmp = tmp.left;
            }
            if (!queue.isEmpty()) {
                tmp = queue.pollLast();
                tmp = tmp.right;
            }
        }
    }

    public static void levelOrder(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            list.add(node.val);
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }

    public static void change(TreeNode root) {
        if (root == null) {
            return;
        }
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(root);

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            TreeNode tmp = node.left;
            node.left = node.right;
            node.right = tmp;
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
    }
}
