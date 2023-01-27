package com.yangxvhao.demo.proxy.offer;

import com.yangxvhao.demo.proxy.ListNodeUtil;
import com.yangxvhao.demo.proxy.ListNodeUtil.ListNode;

/**
 * 输入两个链表，找出它们的第一个公共节点。
 *
 * @author yangxvhao
 * @date 2023-01-25 18:44.
 */
public class Topic52 {

    ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode a = headA, b = headB;
        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }
        return a;
    }

    public static void main(String[] args) {
        ListNode headA = ListNodeUtil.buildFromArray(new int[]{4});
        ListNode commonNode = ListNodeUtil.buildFromArray(new int[]{1,8,4,5});
        ListNode headB = ListNodeUtil.buildFromArray(new int[]{5, 0});
        headA.next = commonNode;
        headB.next = commonNode;

        System.out.println(new Topic52().getIntersectionNode(headA, headB).val);
    }
}
