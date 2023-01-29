package com.yangxvhao.demo.proxy.offer;

import java.util.*;

/**
 * 给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
 *
 * @author yangxvhao
 * @date 2023-01-28 21:20.
 */
public class Topic59 {
    /**
     * 使用单调队列：始终保持队列单调递减，队首元素为最大值
     *
     * @param nums
     * @param k
     * @return
     */
    public int[] maxSlidingWindow(int[] nums, int k) {
        int i = 0, j = 0;
        List<Integer> res = new ArrayList<>();
        Deque<Integer> deque = new LinkedList<>();
        for (int l = 0; l < k; l++) {
            while (!deque.isEmpty() && deque.peekLast() < nums[l]) {
                deque.pollLast();
            }
            deque.addLast(nums[l]);
        }
        res.add(deque.peekFirst());
        for (i = 0, j = k; j < nums.length; i++, j++) {
            if (nums[i] == deque.peekFirst()) {
                deque.pop();
            }
            while (!deque.isEmpty() && deque.peekLast() < nums[j]) {
                deque.pollLast();
            }
            deque.addLast(nums[j]);
            res.add(deque.peekFirst());

        }
        int[] result = new int[res.size()];
        for (int i1 = 0; i1 < res.size(); i1++) {
            result[i1] = res.get(i1);
        }
        return result;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Topic59().maxSlidingWindow(new int[]{1, 3, 1, 2, 0, 5}, 3)));
    }
}
