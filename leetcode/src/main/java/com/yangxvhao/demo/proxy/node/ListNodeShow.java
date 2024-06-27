package com.yangxvhao.demo.proxy.node;

import java.util.LinkedList;

import com.yangxvhao.demo.proxy.ListNodeUtil;
import com.yangxvhao.demo.proxy.ListNodeUtil.ListNode;

/**
 * @author yangxuhao <yangxuhao@kuaishou.com>
 * Created on 2024-01-04
 */
public class ListNodeShow {
    public static void main(String[] args) {
        ListNode head = ListNodeUtil.buildFromArray(new int[] {1, 2,3, 4, 5});

//        ListNode listNode = reverseListOpt(head, 2, 4);
        ListNode listNode1 = reverse(head);
        System.out.println();

    }

    public static ListNode reverse(ListNode head){
        ListNode cur = head;
        ListNode pre = null;

        while (cur != null){
            ListNode next = cur.next;
            cur.next = pre;
            pre = cur;
            cur = next;
        }
        return pre;
    }

    public static ListNode reverseList(ListNode head, int m, int n) {
        LinkedList<Integer> queue = new LinkedList<>();
        ListNode cur = head;

        int i = 1;
        while (cur != null) {
            if (i >= m) {
                queue.add(cur.val);
            }
            cur = cur.next;
            i++;
            if (i > n) {
                break;
            }
        }

        ListNode tmp = new ListNode(0);
        tmp.next = head;
        ListNode pre = tmp;
        for (int j = 1; j < m; j++) {
            pre = pre.next;
        }
        while (!queue.isEmpty()) {
            pre.next = new ListNode(queue.pollLast());
            pre = pre.next;
        }

        if (cur != null) {
            pre.next = cur;
        }
        return tmp.next;
    }

    public static ListNode reverseListOpt(ListNode head, int m, int n) {
        ListNode tmp = new ListNode(0);
        tmp.next = head;

        ListNode pre = tmp;

        for (int i = 1; i < m; i++) {
            pre = pre.next;
        }

        ListNode cur = pre.next, next;

        for (int j = 0; j < n - m; j++){
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }

        return tmp.next;
    }
}
