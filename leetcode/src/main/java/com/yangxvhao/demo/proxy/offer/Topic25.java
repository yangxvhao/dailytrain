package com.yangxvhao.demo.proxy.offer;

import java.util.LinkedList;

/**
 * @author yangxvhao
 * @date 2022-12-11 21:26.
 */
public class Topic25 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        ListNode newL = new ListNode(0);
        ListNode cur = newL;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                cur.next = l1;
                l1 = l1.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
            }
            cur = cur.next;
        }
        if (l1 == null) {
            cur.next = l2;
        }
        if (l2 == null) {
            cur.next = l1;
        }
        return newL.next;
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2,3,4,5,6,7,8};
        ListNode head = new ListNode(1);
        ListNode cur = head;
        for (int i = 0; i < arr.length; i++) {
            cur.next= new ListNode(arr[i]);
            cur=cur.next;
        }

        ListNode res = help(head, 3);
        while (res!=null){
            System.out.print(res.val + "->");
            res=res.next;
        }
    }

    public static ListNode help(ListNode head, int k){
        LinkedList<Integer> stack = new LinkedList<>();
        ListNode cur = head;
        ListNode res = new ListNode(0);
        ListNode tmp = res;

        while (cur!=null){
            stack.addLast(cur.val);
            cur=cur.next;
            if(stack.size()==k||cur==null) {
                while (stack.size() != 0) {
                    tmp.next = new ListNode(stack.removeLast());
                    tmp = tmp.next;
                }
            }
        }
        return res.next;
    }
}
