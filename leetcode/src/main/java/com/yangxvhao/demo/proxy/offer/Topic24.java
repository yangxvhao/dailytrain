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
        return recur(head,null);
    }

    public ListNode recur(ListNode cur,ListNode pre) {
        if (cur == null) {
            return pre;
        }

        ListNode res= recur(cur.next, cur);
        cur.next=pre;
        return res;
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
        System.out.println(new Topic24().reverseList(head).val);
    }
}
