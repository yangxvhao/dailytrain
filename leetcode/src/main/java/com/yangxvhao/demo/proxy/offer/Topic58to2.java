package com.yangxvhao.demo.proxy.offer;

/**
 * 字符串的左旋转操作是把字符串前面的若干个字符转移到字符串的尾部。
 * 请定义一个函数实现字符串左旋转操作的功能。比如，输入字符串"abcdefg"和数字2，该函数将返回左旋转两位得到的结果"cdefgab"。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/zuo-xuan-zhuan-zi-fu-chuan-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yangxvhao
 * @date 2023-01-28 20:51.
 */
public class Topic58to2 {
    public String reverseLeftWords(String s, int n) {
//        return method1(s, n);
        return method2(s, n);
    }

    //使用库函数，切割
    private String method1(String s, int n) {
        return s.substring(n) + s.substring(0, n);
    }

    //字符串遍历拼接
    private String method2(String s, int n) {
        StringBuilder builder = new StringBuilder();
        for (int i = n; i < n + s.length(); i++) {
            builder.append(s.charAt(i % s.length()));
        }
        return builder.toString();
    }

    public static void main(String[] args) {
        System.out.println(new Topic58to2().reverseLeftWords("abcdef", 2));
    }
}
