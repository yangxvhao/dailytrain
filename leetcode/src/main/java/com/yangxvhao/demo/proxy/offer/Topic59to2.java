package com.yangxvhao.demo.proxy.offer;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 请定义一个队列并实现函数 max_value 得到队列里的最大值，要求函数max_value、push_back 和 pop_front 的均摊时间复杂度都是O(1)。
 * <p>
 * 若队列为空，pop_front 和 max_value 需要返回 -1
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/dui-lie-de-zui-da-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yangxvhao
 * @date 2023-01-31 16:22.
 */
public class Topic59to2 {
    static class MaxQueue {
        //使用双端队列维护最大值
        Deque<Integer> maxQueue;
        Queue<Integer> queue;

        public MaxQueue() {
            maxQueue = new LinkedList<>();
            queue = new LinkedList<>();
        }

        public int max_value() {
            if (maxQueue.isEmpty()) {
                return -1;
            }
            return maxQueue.peek();
        }

        public void push_back(int value) {
            queue.add(value);
            while (!maxQueue.isEmpty() && maxQueue.peekLast() < value) {
                maxQueue.removeLast();
            }
            maxQueue.addLast(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            Integer poll = queue.poll();
            if (poll.equals(maxQueue.peek())) {
                maxQueue.pop();
            }
            return poll;
        }
    }

    public static void main(String[] args) {
        MaxQueue maxQueue = new MaxQueue();
        maxQueue.push_back(1);
        maxQueue.push_back(2);
        System.out.println(maxQueue.max_value());
        System.out.println(maxQueue.pop_front());
        System.out.println(maxQueue.max_value());
    }
}
