package com.yangxvhao.demo.proxy;

/**
 * 
 * 给定两个非空链表来表示两个非负整数。位数按照逆序方式存储，它们的每个节点只存储单个数字。将两数相加返回一个新的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数字都不会以零开头。
 * 
 * @author yangxvhao
 * @date 2018-07-18 下午6:06.
 */
public class Topic2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(4);
//        l1.next.next.next = new ListNode(5);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        addTwoNumbers(l1, l2);
        System.out.println();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        ListNode result = sum;
        while (l1 != null || l2 != null) {

            if (l1 == null && l2 != null) {
                l1 = new ListNode(0);
            }
            if (l1 != null && l2 == null) {
                l2 = new ListNode(0);
            }
            int sumTemp = l1.val + l2.val + sum.val;
            if (sumTemp >= 10) {
                sumTemp = sumTemp - 10;
                if (sum.next == null) {
                    sum.next = new ListNode(1);
                } else {
                    sum.next.val += 1;
                }
            }
            sum.val = sumTemp;
            l1 = l1.next;
            l2 = l2.next;
            if (sum.next == null && (l1 != null || l2 != null)) {
                sum.next = new ListNode(0);
                sum = sum.next;
            } else {
                sum = sum.next;
            }
        }
        return result;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
