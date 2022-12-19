package com.yangxvhao.demo.proxy.offer;

/**
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 * <p>
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * @author yangxvhao
 * @date 2022-12-13 21:02.
 */
public class Topic26 {
    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }

    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if (A == null) {
            return false;
        }
        if (B == null) {
            return false;
        }
        return recur(A, B) || isSubStructure(A.right, B) || isSubStructure(A.left, B);

    }

    public boolean recur(TreeNode a, TreeNode b) {
        if (b == null) {
            return true;
        }
        if (a == null) {
            return false;
        }
        if (a.val == b.val) {
            return recur(a.right, b.right) && recur(a.left, b.left);
        } else {
            return false;
        }
    }

    public static void main(String[] args) {

    }
}
