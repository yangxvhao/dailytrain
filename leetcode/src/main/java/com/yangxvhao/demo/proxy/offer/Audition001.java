package com.yangxvhao.demo.proxy.offer;

import java.util.LinkedList;

/**
 * 字节广告一面
 * 给一个链表，按照每k个进行反转
 *
 * @author yangxvhao
 * @date 2022-12-31 12:10.
 */
public class Audition001 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    private static ListNode help(ListNode head, int k) {
        LinkedList<Integer> stack = new LinkedList<>();
        ListNode cur = head;
        ListNode res = new ListNode(0);
        ListNode tmp = res;

        while (cur != null) {
            stack.addLast(cur.val);
            cur = cur.next;
            if (stack.size() == k || cur == null) {
                while (stack.size() != 0) {
                    tmp.next = new ListNode(stack.removeLast());
                    tmp = tmp.next;
                }
            }
        }
        return res.next;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 4, 5, 6, 7, 8};
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 0; i < arr.length; i++) {
            cur.next = new ListNode(arr[i]);
            cur = cur.next;
        }

        ListNode res = help(head, 3);
        while (res != null) {
            System.out.print(res.val + "->");
            res = res.next;
        }
    }
}
