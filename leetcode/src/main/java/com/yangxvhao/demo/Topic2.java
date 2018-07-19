package com.yangxvhao.demo;

public class Topic2 {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(2);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(3);

        ListNode l2 = new ListNode(5);
        l2.next = new ListNode(6);
        l2.next.next = new ListNode(4);

        addTwoNumbers(l1, l2);
        System.out.println();
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode sum = new ListNode(0);
        while (l1.next != null || l2.next != null) {
            if (l1 == null && l2!= null){
                l1 = new ListNode(0);
            }
            if(l1 != null&&l2 == null){
                l2 = new ListNode(0);
            }
            int sumTemp = l1.val + l2.val;
            if (sumTemp > 10) {
                sumTemp = sumTemp - 10;
                sum.next.val += 1;
                sum.val = sumTemp;
            }
            sum.val = sumTemp;
        }
        return sum;
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
