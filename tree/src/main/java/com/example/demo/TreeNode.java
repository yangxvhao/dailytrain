package com.example.demo;

/**
 * @author yangxvhao
 * @date 18-4-24.
 */

public class TreeNode {
    public int val;
    
    public TreeNode left;
    
    public TreeNode right;

    public void setVal(int val) {
        this.val = val;
    }

    public void setLeft(TreeNode left) {
        this.left = left;
    }

    public void setRight(TreeNode right) {
        this.right = right;
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode() {
    }
}
