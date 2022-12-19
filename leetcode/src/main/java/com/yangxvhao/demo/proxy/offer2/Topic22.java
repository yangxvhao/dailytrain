package com.yangxvhao.demo.proxy.offer2;

/**
 * 给定一个链表，返回链表开始入环的第一个节点。 从链表的头节点开始沿着 next 指针进入环的第一个节点为环的入口节点。如果链表无环，则返回 null。
 * <p>
 * 为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。注意，pos 仅仅是用于标识环的情况，并不会作为参数传递到函数中
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/c32eOV
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yangxvhao
 * @date 2022-12-19 16:38.
 */
public class Topic22 {
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode fast = head, slow = head;
        while (true) {
            if (fast == null || fast.next == null) {
                return null;
            }
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                break;
            }
        }
        if (fast != slow) {
            return null;
        }
        fast = head;
        while (fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }
        return fast;
    }

    public static void main(String[] args) {
        //head = [3,2,0,-4], pos = 1
        ListNode head = new ListNode(3);
        ListNode first = new ListNode(2);
        head.next = first;
        first.next = new ListNode(0);
        ListNode last = new ListNode(-4);
        first.next.next = last;
        last.next = first;

        System.out.println(new Topic22().detectCycle(head).val);
    }
}
