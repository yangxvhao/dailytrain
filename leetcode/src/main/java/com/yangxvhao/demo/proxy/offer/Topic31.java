package com.yangxvhao.demo.proxy.offer;

import java.util.Stack;

/**
 * 输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如，序列 {1,2,3,4,5} 是某栈的压栈序列，序列 {4,5,3,2,1} 是该压栈序列对应的一个弹出序列，但 {4,3,5,1,2} 就不可能是该压栈序列的弹出序列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/zhan-de-ya-ru-dan-chu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yangxvhao
 * @date 2022-12-23 15:23.
 */
public class Topic31 {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int j = 0;
        for (int i : pushed) {
            stack.push(i);
            while (!stack.isEmpty() && stack.peek().equals(popped[j])) {
                stack.pop();
                j++;
            }
        }
        return stack.isEmpty();
    }

    public boolean validateStackSequences1(int[] pushed, int[] popped) {
        int j=popped.length-1;
        for (int i = 0; i < pushed.length; i++) {
            while (pushed[i]==popped[j]){
                j--;
                i++;
            }
        }
        return j==0;
    }

    public static void main(String[] args) {
        int[] pushed = new int[]{1, 2, 3, 4, 5};
        int[] popped = new int[]{4, 5, 3, 2, 1};
        System.out.println(new Topic31().validateStackSequences1(pushed, popped));

    }
}
