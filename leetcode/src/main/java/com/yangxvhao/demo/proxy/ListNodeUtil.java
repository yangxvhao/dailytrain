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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            ListNode listNode = (ListNode) o;
            return val == listNode.val &&
                    Objects.equals(next, listNode.next);
        }

        @Override
        public int hashCode() {
            return Objects.hash(val, next);
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
}
