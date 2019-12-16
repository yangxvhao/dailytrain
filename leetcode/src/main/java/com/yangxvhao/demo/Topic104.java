package com.yangxvhao.demo;

import java.util.LinkedList;

/**
 * @author yangx
 * @date 2019-12-12 11:22.
 */
public class Topic104 {
    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode l = new TreeNode(2);
        TreeNode r = new TreeNode(3);
        TreeNode l1 = new TreeNode(4);
        TreeNode ri = new TreeNode(5);
        root.lift = l;
        l.lift = r;
        l.right = l1;
        root.right = ri;
        flatten(root);
    }

    static class TreeNode{
        private TreeNode right;
        private TreeNode lift;
        private int value;

        public TreeNode(int value) {
            this.value = value;
        }
    }
    private  static TreeNode prev = null;

    public static void flatten(TreeNode root) {
        if(root == null)
            return;
        flatten(root.right);
        flatten(root.lift);
        root.right = prev;
        root.lift = null;
        prev = root;
    }
}
