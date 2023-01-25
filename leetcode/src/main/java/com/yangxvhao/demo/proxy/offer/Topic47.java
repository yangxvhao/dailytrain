package com.yangxvhao.demo.proxy.offer;

import com.yangxvhao.demo.proxy.Topic4;

/**
 * 在一个 m*n 的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值（价值大于 0）。
 * 你可以从棋盘的左上角开始拿格子里的礼物，并每次向右或者向下移动一格、直到到达棋盘的右下角。
 * 给定一个棋盘及其上面的礼物的价值，请计算你最多能拿到多少价值的礼物？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/li-wu-de-zui-da-jie-zhi-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yangxvhao
 * @date 2023-01-24 16:28.
 */
public class Topic47 {
    public int maxValue(int[][] grid) {
        return dp1(grid);
    }

    /**
     * 状态:dp[i][j]表示从grid[0][0]到grid[i][j]的礼物最大值
     * 转移方程:dp[i][j]=max(dp[i][j-1],dp[i-1][j]) + grid[i][j]
     * 顺序:
     * 初始值:dp[0-i][j],dp[i][0-j]
     *
     * @param grid
     * @return
     */
    private int dp1(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        dp[0][0] = grid[0][0];
        int max = dp[0][0];
        for (int i = 1; i < grid.length; i++) {
            dp[i][0] = grid[i][0] + dp[i - 1][0];
            if (dp[i][0] > max) {
                max = dp[i][0];
            }
        }
        for (int i = 1; i < grid[0].length; i++) {
            dp[0][i] = grid[0][i] + dp[0][i - 1];
            if (dp[0][i] > max) {
                max = dp[0][i];
            }
        }

        for (int i = 1; i < grid.length; i++) {
            for (int j = 1; j < grid[i].length; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
                if (dp[i][j] > max) {
                    max = dp[i][j];
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] grid = new int[][]{
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(new Topic47().maxValue(grid));
        grid = new int[][]{
                {9,1,4,8}
        };
        System.out.println(new Topic47().maxValue(grid));
    }
}
