package com.yangxvhao.demo.proxy.hot100;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yangxvhao
 * @date 2023-02-06 20:11.
 */
public class Topic20 {
    /**
     * 利用栈的特性，来保证括号的顺序
     *
     * @param s
     * @return
     */
    public boolean isValid(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }
        Deque<Character> queue = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                queue.addFirst(c);
            } else {
                if (queue.isEmpty()) {
                    return false;
                } else {
                    if (c == ')' && '(' != queue.poll()) {
                        return false;
                    } else if (c == '}' && '{' != queue.poll()) {
                        return false;
                    } else if (c == ']' && '[' != queue.poll()) {
                        return false;
                    }
                }
            }
        }
        return queue.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Topic20().isValid("()"));
        System.out.println(new Topic20().isValid("()[]{}[]"));
        System.out.println(new Topic20().isValid("()["));
        System.out.println(new Topic20().isValid("([])"));
        System.out.println(new Topic20().isValid("([)]"));
    }
}
