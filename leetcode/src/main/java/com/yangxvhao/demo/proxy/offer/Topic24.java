package com.yangxvhao.demo.proxy.offer;

import java.util.List;

/**
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 *
 * @author yangxvhao
 * @date 2022-12-05 22:10.
 */
public class Topic24 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode reverseList(ListNode head) {
        return recur(head, null);
    }

    public ListNode recur(ListNode cur, ListNode pre) {
        if (cur == null) {
            return pre;
        }

        ListNode res = recur(cur.next, cur);
        cur.next = pre;
        return res;
    }

    public ListNode reverseListOpt(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode cur = head, pre = null;
        while (cur != null) {
            ListNode tmp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = tmp;
        }
        return pre;
    }

    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null) {
            return null;
        }
        ListNode dummyNode = new ListNode(-1);
        dummyNode.next = head;

        ListNode pre = dummyNode;
        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
        }
        ListNode cur = pre.next, next;
        // 1-2-3-4-5
        for (int i = 0; i < right - left; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode one = new ListNode(2);
        ListNode two = new ListNode(3);
        ListNode three = new ListNode(4);
        ListNode four = new ListNode(5);
        head.next = one;
        one.next = two;
        two.next = three;
        three.next = four;
//        System.out.println(new Topic24().reverseListOpt(head).val);
        System.out.println(new Topic24().reverseBetween(four, 1, 1).val);
    }
}
