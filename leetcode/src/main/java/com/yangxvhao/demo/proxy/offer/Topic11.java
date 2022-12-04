package com.yangxvhao.demo.proxy.offer;

/**
 * 把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。
 *
 * 给你一个可能存在 重复 元素值的数组 numbers ，它原来是一个升序排列的数组，并按上述情形进行了一次旋转。请返回旋转数组的最小元素。
 * 例如，数组 [3,4,5,1,2] 为 [1,2,3,4,5] 的一次旋转，该数组的最小值为 1。 
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/xuan-zhuan-shu-zu-de-zui-xiao-shu-zi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @author yangxvhao
 * @date 2022-12-03 16:16.
 */
public class Topic11 {
    public int minArray(int[] numbers) {
        int i =0, j=numbers.length -1,m=(j+i)/2;
        while (i <j){

            if(numbers[m] > numbers[j]){
                i = m+1;
                m = (j+i)/2;
            }else if(numbers[m] < numbers[j]){
                j = m;
                m = (j+i)/2;
            }else {
                int x = i;
                for (int k = i + 1; k < j; k++) {
                    if(numbers[k] < numbers[x]){
                        x = k;
                    }
                }
                return numbers[x];
            }
        }
        return numbers[i];
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2,2,2,0,2};
        System.out.println(new Topic11().minArray(nums));
    }
}
