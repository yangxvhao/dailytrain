package com.yangxvhao.demo.proxy.offer;

/**
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。但它不能进入方格 [35, 38]，
 * 因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yangxvhao
 * @date 2023-01-31 15:28.
 */
public class Topic13 {
    //DFS搜索
    public int movingCount(int m, int n, int k) {
        boolean[][] visited = new boolean[m][n];
        return dfs(visited, m, n, k, 0, 0);
    }

    private int dfs(boolean[][] visited, int m, int n, int k, int i, int j) {
        if (i >= m || j >= n || visited[i][j] || (k - bitSum(i) - bitSum(j)) < 0) {
            return 0;
        }
        visited[i][j] = true;
        //向下，向右搜索即可
        return 1 + dfs(visited, m, n, k, i + 1, j) + dfs(visited, m, n, k, i, j + 1);
    }

    private int bitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum = sum + num % 10;
            num = num / 10;
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Topic13().movingCount(2,3,1));
        System.out.println(new Topic13().movingCount(3,1,0));
    }
}
