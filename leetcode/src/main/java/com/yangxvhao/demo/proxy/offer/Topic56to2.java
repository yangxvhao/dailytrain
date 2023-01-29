package com.yangxvhao.demo.proxy.offer;

/**
 * 在一个数组 nums 中除一个数字只出现一次之外，其他数字都出现了三次。请找出那个只出现一次的数字。
 *
 * @author yangxvhao
 * @date 2023-01-27 20:48.
 */
public class Topic56to2 {
    /**
     * 1.利用与操作和无符号右移 统计每一位二进制上面1的出现次数
     * 2.能被3整除代表出现了三次，剩下的即为出现一次的数字
     *
     * @param nums
     * @return
     */
    public int singleNumber(int[] nums) {
        int[] bit = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                bit[j] = bit[j] + (nums[i] & 1);
                nums[i] = nums[i] >>> 1;
            }
        }
        int res = 0;
        for (int i = 0; i < bit.length; i++) {
            res = res << 1;
            res = res | (bit[31 - i] % 3);
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(new Topic56to2().singleNumber(new int[]{3, 4, 3, 3}));
    }
}
