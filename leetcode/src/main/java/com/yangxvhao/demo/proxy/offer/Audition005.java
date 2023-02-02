package com.yangxvhao.demo.proxy.offer;

import com.yangxvhao.demo.proxy.ListNodeUtil;
import com.yangxvhao.demo.proxy.ListNodeUtil.ListNode;

/**
 * 快手二面
 * 链表反转，从m到n反转
 *
 * @author yangxvhao
 * @date 2023-01-20 14:37.
 */
public class Audition005 {
    /**
     * 穿针引线头插法，定义三个指针
     * cur当前，pre前驱，next后驱
     *
     * @param head
     * @return
     */
    ListNode reverse(ListNode head, int m, int n) {
        ListNode dummyNode = new ListNode(0);
        dummyNode.next = head;
        ListNode pre = dummyNode, cur, next;
        //先走到要反转地方
        for (int i = 0; i < m; i++) {
            pre = pre.next;
        }
        cur = pre.next;
        for (int i = 0; i < n - m; i++) {
            next = cur.next;
            cur.next = next.next;
            next.next = pre.next;
            pre.next = next;
        }
        return dummyNode.next;
    }

    public static void main(String[] args) {
        ListNode head = ListNodeUtil.buildFromArray(new int[]{1, 2, 3, 4, 5, 6});
        ListNodeUtil.show(head);
        ListNode reverse = new Audition005().reverse(head, 2, 4);
        ListNodeUtil.show(reverse);
    }
}
