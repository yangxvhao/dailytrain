package com.yangxvhao.demo.proxy.hot100;

import java.util.*;

/**
 * 给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 * <p>
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/letter-combinations-of-a-phone-number
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yangxvhao
 * @date 2023-02-03 15:26.
 */
public class Topic17 {
    public List<String> letterCombinations(String digits) {
        return method1(digits);
    }

    /**
     * 暴力遍历
     *
     * @param digits
     * @return
     */
    private List<String> method1(String digits) {
        if (digits.length() == 0) {
            return new ArrayList<>();
        }
        Map<Character, String> dict = new HashMap<>();
        dict.put('2', "abc");
        dict.put('3', "def");
        dict.put('4', "ghi");
        dict.put('5', "jkl");
        dict.put('6', "mno");
        dict.put('7', "pqrs");
        dict.put('8', "tuv");
        dict.put('9', "wxyz");

        List<String> res = new ArrayList<>();
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < digits.length(); i++) {
            String word = dict.get(digits.charAt(i));
            if (word == null) {
                continue;
            }
            if (queue.isEmpty()) {
                for (int j = 0; j < word.length(); j++) {
                    if (i == digits.length() - 1) {
                        res.add(word.charAt(j) + "");
                    } else {
                        queue.add(word.charAt(j) + "");
                    }
                }
            } else {
                int len = queue.size();
                for (int j = 0; j < len; j++) {
                    String c = queue.poll();
                    for (int k = 0; k < word.length(); k++) {
                        if (i == digits.length() - 1) {
                            res.add(c + word.charAt(k));
                        } else {
                            queue.add(c + word.charAt(k));
                        }
                    }
                }
            }
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Topic17().letterCombinations("123"));
        System.out.println(new Topic17().letterCombinations(""));
        System.out.println(new Topic17().letterCombinations("2"));
    }
}
