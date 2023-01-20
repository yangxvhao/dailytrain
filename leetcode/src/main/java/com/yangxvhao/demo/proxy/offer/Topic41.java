package com.yangxvhao.demo.proxy.offer;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * 如何得到一个数据流中的中位数？如果从数据流中读出奇数个数值，那么中位数就是所有数值排序之后位于中间的数值。
 * 如果从数据流中读出偶数个数值，那么中位数就是所有数值排序之后中间两个数的平均值。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/shu-ju-liu-zhong-de-zhong-wei-shu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yangxvhao
 * @date 2023-01-20 13:23.
 */
public class Topic41 {
    static class MedianFinder {
        //使用优先级队列
        //大——》小，队首为最大元素，存储的是小的那一半
        PriorityQueue<Integer> smallQueue;
        //小-》大，队首为最小元素，存储的是大的那一半
        PriorityQueue<Integer> bigQueue;

        /**
         * initialize your data structure here.
         */
        public MedianFinder() {
            smallQueue = new PriorityQueue<>(Comparator.reverseOrder());
            bigQueue = new PriorityQueue<>();
        }

        //优先添加到大的那一半
        public void addNum(int num) {
            if (smallQueue.size() != bigQueue.size()) {
                bigQueue.add(num);
                smallQueue.add(bigQueue.poll());
            } else {
                smallQueue.add(num);
                bigQueue.add(smallQueue.poll());
            }
        }

        public double findMedian() {
            //奇数个，取大的那一半的队首元素
            if (smallQueue.size() != bigQueue.size()) {
                return bigQueue.peek() / 1.0;
            } else {
                return (bigQueue.peek() + smallQueue.peek()) / 2.0;
            }
        }
    }

    public static void main(String[] args) {
        MedianFinder medianFinder = new MedianFinder();
        medianFinder.addNum(-1);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-2);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-3);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-4);
        System.out.println(medianFinder.findMedian());
        medianFinder.addNum(-5);
        System.out.println(medianFinder.findMedian());
    }
}
