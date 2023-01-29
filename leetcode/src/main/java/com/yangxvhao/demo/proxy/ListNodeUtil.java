package com.yangxvhao.demo.proxy;

import java.util.Objects;

/**
 * @author yangxvhao
 * @date 2023-01-25 20:20.
 */
public class ListNodeUtil {
    public static class ListNode {
        public int val;
        public ListNode next;

        public ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode buildFromArray(int[] nums) {
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        for (int num : nums) {
            cur.next = new ListNode(num);
            cur = cur.next;
        }
        return dummyNode.next;
    }

    public static class TreeNode {
        public int val;
        public TreeNode left;
        public TreeNode right;

        public TreeNode(int val) {
            this.val = val;
        }

        public TreeNode(int val, TreeNode left, TreeNode right){
            this.val = val;
            this.left = left;
            this.right = right;
        }

        public TreeNode(int val, TreeNode left){
            this.val = val;
            this.left = left;
        }

    }

    public static TreeNode buildRootFromArray(int[] nums) {
        TreeNode root = null;
        root = recur(0, nums);
        return root;
    }

    private static TreeNode recur(int index, int[] nums) {
        if (index >= nums.length) {
            return null;
        }
        TreeNode root = new TreeNode(nums[index]);
        root.left = recur(index + 1, nums);
        root.right = recur(index + 2, nums);
        return root;
    }
}
