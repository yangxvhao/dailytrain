package com.yangxvhao.demo.proxy.offer;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 * @author yangxvhao
 * @date 2023-01-31 15:56.
 */
public class Topic45 {
    public String minNumber(int[] nums) {
//        Queue<String> queue = new PriorityQueue<>((x, y) -> (x + y).compareTo(y + x));
        Queue<String> queue = new PriorityQueue<>((x, y) -> (y + x).compareTo(x + y));
        for (int i = 0; i < nums.length; i++) {
            queue.add("" + nums[i]);
        }
        StringBuilder builder = new StringBuilder();
        while (!queue.isEmpty()) {
            builder.append(queue.poll());
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Topic45().minNumber(new int[]{10, 2}));
        System.out.println(new Topic45().minNumber(new int[]{3, 30, 34, 5, 9}));
    }
}
