package com.yangxvhao.demo.proxy.offer;

/**
 * 输入一个英文句子，翻转句子中单词的顺序，但单词内字符的顺序不变。为简单起见，标点符号和普通字母一样处理。例如输入字符串"I am a student. "，则输出"student. a am I"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/fan-zhuan-dan-ci-shun-xu-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yangxvhao
 * @date 2023-01-28 20:20.
 */
public class Topic58 {
    /**
     * 双指针
     *
     * @param s
     * @return
     */
    public String reverseWords(String s) {
        s = s.trim();
        int i = s.length() - 1, j = i;
        StringBuilder builder = new StringBuilder();
        while (i >= 0) {
            //寻找第一个空格
            while (i >= 0 && s.charAt(i) != ' ') {
                i--;
            }
            builder.append(s, i + 1, j + 1).append(' ');
            //寻找下一个单词
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            j = i;
        }
        return builder.deleteCharAt(builder.length() - 1).toString();
    }

    public static void main(String[] args) {
        System.out.println(new Topic58().reverseWords("I am a student. "));
        System.out.println(new Topic58().reverseWords("a good   example"));
    }
}
