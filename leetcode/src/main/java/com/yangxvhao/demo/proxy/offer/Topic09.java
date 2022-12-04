package com.yangxvhao.demo.proxy.offer;

import java.util.LinkedList;

/**
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/yong-liang-ge-zhan-shi-xian-dui-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author yangxvhao
 * @date 2022-12-03 13:59.
 */
public class Topic09 {
    static class CQueue {
        private LinkedList<Integer> in;
        private LinkedList<Integer> out;

        public CQueue() {
            in = new LinkedList<>();
            out = new LinkedList<>();
        }

        public void appendTail(int value) {
            in.addLast(value);

        }

        public int deleteHead() {
            if(!out.isEmpty()){
                return out.removeFirst();
            }
            if(in.isEmpty()){
                return -1;
            }
            while (!in.isEmpty()){
                out.addFirst(in.removeLast());
            }
            return out.removeFirst();
        }
    }

    public static void main(String[] args) {
        CQueue cQueue1 = new CQueue();
        cQueue1.appendTail(3);
        System.out.println(cQueue1.deleteHead());
        System.out.println(cQueue1.deleteHead());
        System.out.println(cQueue1.deleteHead());

        CQueue cQueue2 = new CQueue();
        System.out.println(cQueue2.deleteHead());
        cQueue2.appendTail(5);
        cQueue2.appendTail(2);
        System.out.println(cQueue2.deleteHead());
        System.out.println(cQueue2.deleteHead());
    }
}
