package com.yangxvhao.demo.proxy.hot100;

import com.yangxvhao.demo.proxy.ListNodeUtil;
import com.yangxvhao.demo.proxy.ListNodeUtil.ListNode;

import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。
 *
 * @author yangxvhao
 * @date 2023-02-07 20:28.
 */
public class Topic21 {
    /**
     * 利用小顶堆特性，保存两个链表，再重新构建新链表
     * <p>
     * 不符合题意，需要再给定节点拼接组成
     *
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        Queue<Integer> queue = new PriorityQueue<>();
        while (list1 != null) {
            queue.add(list1.val);
            list1 = list1.next;
        }
        while (list2 != null) {
            queue.add(list2.val);
            list2 = list2.next;
        }
        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        while (!queue.isEmpty()) {
            cur.next = new ListNode(queue.poll());
            cur = cur.next;
        }
        return dummyNode.next;
    }

    /**
     * @param list1
     * @param list2
     * @return
     */
    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {

        ListNode dummyNode = new ListNode(0);
        ListNode cur = dummyNode;
        while (list1 != null && list2 != null) {
            if (list1.val > list2.val) {
                cur.next = list2;
                list2 = list2.next;
            } else {
                cur.next = list1;
                list1 = list1.next;
            }
            cur = cur.next;
        }
        cur.next = list1 == null ? list2 : list1;
        return dummyNode.next;
    }

    public static void main(String[] args) {
//        ListNode list1 = ListNodeUtil.buildFromArray(new int[]{1, 2, 3});
        ListNode list1 = ListNodeUtil.buildFromArray(new int[]{});
//        ListNode list2 = ListNodeUtil.buildFromArray(new int[]{2, 3, 4});
        ListNode list2 = ListNodeUtil.buildFromArray(new int[]{2, 3, 4});
        System.out.println(new Topic21().mergeTwoLists(list1, list2).val);
        System.out.println(new Topic21().mergeTwoLists1(list2, list1).val);
    }
}
