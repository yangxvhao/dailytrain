package com.yangxvhao.demo.proxy;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个包含大写字母和小写字母的字符串 s ，返回 通过这些字母构造成的 最长的回文串 。
 *
 * 在构造过程中，请注意 区分大小写 。比如 "Aa" 不能当做一个回文字符串。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/longest-palindrome
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author yangxvhao
 * @date 2023-01-31 12:49.
 */
public class Topic409 {
    public int longestPalindrome(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            map.merge(c, 1, Integer::sum);
        }
        int res = 0, odd = 0;
        for (Map.Entry<Character, Integer> entry : map.entrySet()) {
            int count = entry.getValue();
            int rem = count % 2;
            //count是偶数rem=0,count是奇数rem=1,这样可以做到偶数个全部计数，奇数个里的偶数也计数
            res = res + count - rem;
            //奇数个只能有一个，所以记一次
            if (rem == 1) {
                odd = 1;
            }
        }
        return res + odd;
    }

    public static void main(String[] args) {
        System.out.println(new Topic409().longestPalindrome("abccccdd"));
        System.out.println(new Topic409().longestPalindrome("aaaaaccc"));
        System.out.println(new Topic409().longestPalindrome("a"));
    }
}
