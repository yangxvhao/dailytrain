package com.yangxvhao.demo.proxy.offer;

import java.util.HashMap;
import java.util.Map;

/**
 * 请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。
 * <p>
 * 数值（按顺序）可以分成以下几个部分：
 * <p>
 * 若干空格
 * 一个 小数 或者 整数
 * （可选）一个 'e' 或 'E' ，后面跟着一个 整数
 * 若干空格
 * 小数（按顺序）可以分成以下几个部分：
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * 下述格式之一：
 * 至少一位数字，后面跟着一个点 '.'
 * 至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
 * 一个点 '.' ，后面跟着至少一位数字
 * 整数（按顺序）可以分成以下几个部分：
 * <p>
 * （可选）一个符号字符（'+' 或 '-'）
 * 至少一位数字
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yangxvhao
 * @date 2022-12-05 17:16.
 */
public class Topic20 {
    /**
     * 空格，数字，小数点，正负号，e/E
     * 有限状态自动机，所有状态
     * 例子：" +1.2e-1 "
     * 0：开头的空格
     * 1：e前的正负号
     * 2：小数点前的数字
     * 3：小数点后的数字
     * 4：空格小数点后的数字
     * 5：e后的正负号
     * 6：e后的数字
     * 7：e
     * 8：结尾的空格
     * 合法的结束状态：3，4，6，8
     *
     * @param s
     * @return
     */
    public boolean isNumber(String s) {
        Map[] maps = {
                new HashMap<String, Integer>() {{
                    put(" ", 0);
                    put("s", 1);
                    put("d", 2);
                    put(".", 4);
                }},  //0
                new HashMap<String, Integer>() {{
                    put("d", 2);
                    put(".", 4);
                }},  //1
                new HashMap<String, Integer>() {{
                    put("d", 2);
                    put(".", 3);
                    put("e", 7);
                    put(" ", 8);
                }},  //2
                new HashMap<String, Integer>() {{
                    put("e", 7);
                    put("d", 3);
                    put(" ", 8);
                }},  //3
                new HashMap<String, Integer>() {{
                    put("d", 3);
                }},  //4
                new HashMap<String, Integer>() {{
                    put("d", 6);
                }},  //5
                new HashMap<String, Integer>() {{
                    put("d", 6);
                    put(" ", 8);
                }},  //6
                new HashMap<String, Integer>() {{
                    put("s", 5);
                    put("d", 6);
                }},  //7
                new HashMap<String, Integer>() {{
                    put(" ", 8);
                }},  //8
        };
        String type;
        int p = 0;
        for (char c : s.toCharArray()) {
            if (c == ' ' || c == '.') {
                type = String.valueOf(c);
            } else if (c == '+' || c == '-') {
                type = "s";
            } else if (c >= '0' && c <= '9') {
                type = "d";
            } else if (c == 'e' || c == 'E') {
                type = "e";
            } else {
                type = "?";
            }
            if (!maps[p].containsKey(type)) {
                return false;
            }
            p = (int) maps[p].get(type);
        }
        return p == 2 || p == 3 || p == 6 || p == 8;
    }

    public static void main(String[] args) {
        System.out.println(new Topic20().isNumber(".20"));
        System.out.println(new Topic20().isNumber("0"));
        System.out.println(new Topic20().isNumber("e"));
        System.out.println(new Topic20().isNumber("."));
    }
}
