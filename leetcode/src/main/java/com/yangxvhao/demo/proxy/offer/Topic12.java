package com.yangxvhao.demo.proxy.offer;

/**
 * 给定一个 m x n 二维字符网格 board 和一个字符串单词 word 。如果 word 存在于网格中，返回 true ；否则，返回 false 。
 * <p>
 * 单词必须按照字母顺序，通过相邻的单元格内的字母构成，其中“相邻”单元格是那些水平相邻或垂直相邻的单元格。同一个单元格内的字母不允许被重复使用。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/ju-zhen-zhong-de-lu-jing-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 *
 * @author yangxvhao
 * @date 2022-12-04 11:49.
 */
public class Topic12 {

    public boolean exist(char[][] board, String word) {
        char[] wordChar = word.toCharArray();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (dfs(board, wordChar, i, j, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, char[] word, int i, int j, int k) {
        if (k == word.length) {
            return true;
        }
        if (i < 0 || i >= board.length || j < 0 || j >= board[0].length || word[k] != board[i][j]) {
            return false;
        }
        board[i][j] = '\0';
        boolean res = dfs(board, word, i + 1, j, k + 1) ||
                dfs(board, word, i - 1, j, k + 1) ||
                dfs(board, word, i, j + 1, k + 1) ||
                dfs(board, word, i, j - 1, k + 1);
        board[i][j] = word[k];
        return res;
    }

    public static void main(String[] args) {
        char[][] board = new char[][]{
                {'A', 'B', 'C', 'E'},
                {'S', 'F', 'C', 'S'},
                {'A', 'D', 'E', 'E'}};
        String word = "SEE";
        System.out.println(new Topic12().exist(board, word));
    }
}
