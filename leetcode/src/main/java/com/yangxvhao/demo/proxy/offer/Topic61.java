package com.yangxvhao.demo.proxy.offer;

import java.util.HashSet;
import java.util.Set;

/**
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。
 * 2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/bu-ke-pai-zhong-de-shun-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yangxvhao
 * @date 2023-01-31 17:07.
 */
public class Topic61 {
    /**
     * 判断顺子的条件：不重复且max-min<5
     * 大小王跳过
     *
     * @param nums
     * @return
     */
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>(5);
        int max = -1, min = 14;
        for (int num : nums) {
            if (num == 0) {
                continue;
            }
            if (set.contains(num)) {
                return false;
            } else {
                set.add(num);
            }
            if (num > max) {
                max = num;
            }
            if (num < min) {
                min = num;
            }
        }
        return max - min < 5;
    }

    public static void main(String[] args) {
        System.out.println(new Topic61().isStraight(new int[]{1, 2, 3, 4, 5}));
        System.out.println(new Topic61().isStraight(new int[]{0, 0, 1, 2, 5}));
        System.out.println(new Topic61().isStraight(new int[]{0, 0, 1, 2, 2}));
    }
}
