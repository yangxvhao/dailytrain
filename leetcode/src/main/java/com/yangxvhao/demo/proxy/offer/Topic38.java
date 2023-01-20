package com.yangxvhao.demo.proxy.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * 输入一个字符串，打印出该字符串中字符的所有排列。
 * 你可以以任意顺序返回这个字符串数组，但里面不能有重复元素。
 *
 * @author yangxvhao
 * @date 2023-01-03 15:49.
 */
public class Topic38 {
    static List<String> res = new ArrayList<>();

    public String[] permutation(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        char[] chars = s.toCharArray();
        dfs(chars, 0);
        String[] resArray = new String[res.size()];
        res.toArray(resArray);
        return resArray;
    }

    private static void dfs(char[] chars, int x) {
        if (x == chars.length) {
            res.add(String.valueOf(chars));
        }
        HashSet<Character> set = new HashSet<>();
        for (int i = x; i < chars.length; i++) {
            if (set.contains(chars[i])) {
                continue;
            }
            swap(chars, i, x);
            set.add(chars[i]);
            dfs(chars, x + 1);
            swap(chars, x, i);
        }
    }

    private static void swap(char[] chars, int source, int target) {
        char tmp = chars[source];
        chars[source] = chars[target];
        chars[target] = tmp;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(new Topic38().permutation("aab")));
    }
}
