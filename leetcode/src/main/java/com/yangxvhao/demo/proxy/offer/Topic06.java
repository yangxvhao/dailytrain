package com.yangxvhao.demo.proxy.offer;

import java.util.Arrays;
import java.util.logging.Handler;

/**
 * 输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
 *
 * @author yangxvhao
 * @date 2022-12-02 10:52.
 */
public class Topic06 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public int[] reversePrint(ListNode head) {
        return recur(head, 0);
    }

    int[] recur(ListNode head, int size){
        if(head == null){
            return new int[size];
        }
        int[] result =recur(head.next, size + 1);
        result[result.length -1 - size] = head.val;
        return result;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(1);
        System.out.println(Arrays.toString(new Topic06().reversePrint(head)));

    }
}
