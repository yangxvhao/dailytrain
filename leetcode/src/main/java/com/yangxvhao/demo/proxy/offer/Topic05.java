package com.yangxvhao.demo.proxy.offer;

/**
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 *
 * @author yangxvhao
 * @date 2022-12-02 10:38.
 */
public class Topic05 {
    public String replaceSpace(String s) {
        if (s == null) {
            return s;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (c == ' ') {
                stringBuilder.append("%20");
            } else {
                stringBuilder.append(c);
            }
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Topic05().replaceSpace("HELLO WORLD"));
    }
}
