package com.yangxvhao.demo.proxy.hot100;

import com.yangxvhao.demo.proxy.ListNodeUtil;
import com.yangxvhao.demo.proxy.ListNodeUtil.ListNode;

/**
 * 给你一个链表，删除链表的倒数第 n 个结点，并且返回链表的头结点。
 *
 * @author yangxvhao
 * @date 2023-02-06 19:34.
 */
public class Topic19 {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        return method1(head, n);
    }

    /**
     * 双指针：
     * 第一个指针走n步时，第二个指针开始走，当第一个指针走到结尾时，第二个指针的位置即为倒数第n个
     *
     * @param head
     * @param n
     * @return
     */
    private ListNode method1(ListNode head, int n) {
        ListNode first = head;
        //引入虚拟节点的原因是可能删除的是头节点
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode second = dummyNode;
        int count = 1;
        while (first.next != null) {
            if (count >= n) {
                second = second.next;
            }
            first = first.next;
            count++;
        }

        second.next = second.next.next;
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeUtil.buildFromArray(new int[]{1});
//        System.out.println(new Topic19().removeNthFromEnd(head, 2).val);
        System.out.println(new Topic19().removeNthFromEnd(head, 1).val);
    }
}
