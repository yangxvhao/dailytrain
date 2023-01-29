package com.yangxvhao.demo.proxy.offer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 * <p>
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/he-wei-sde-lian-xu-zheng-shu-xu-lie-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yangxvhao
 * @date 2023-01-28 18:09.
 */
public class Topic57to2 {
    /**
     * 滑动窗口
     * 窗口内序列和大于target，左边界右移
     * 窗口内序列和小于target，右边界右移
     * 等于target，记录序列
     *
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        //序列左边界，序列右边界，序列和
        int i = 1, j = 2, sum = 3;
        List<int[]> ans = new ArrayList<>();
        while (i < j) {
            if (sum == target) {
                int[] tmp = new int[j - i + 1];
                for (int k = i; k <= j; k++) {
                    tmp[k - i] = k;
                }
                ans.add(tmp);
            }
            if (sum >= target) {
                sum = sum - i;
                i++;
            } else {
                j++;
                sum = sum + j;
            }
        }
        return ans.toArray(new int[0][]);
    }

    public static void main(String[] args) {
        System.out.println(Arrays.deepToString(new Topic57to2().findContinuousSequence(9)));
    }
}
