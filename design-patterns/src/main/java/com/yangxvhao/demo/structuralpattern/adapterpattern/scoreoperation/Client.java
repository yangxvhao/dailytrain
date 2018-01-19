package com.yangxvhao.demo.structuralpattern.adapterpattern.scoreoperation;

/**
 * @author yangxvhao
 * @date 18-1-19.
 */

public class Client {
    public static void main(String[] args) {
        ScoreOperation scoreOperation = new Adapter();
        int[] scores = new int[]{1,2,33,2,1,2,23,22};
        scoreOperation.sort(scores);
        scoreOperation.search(scores, 8);
    }
}
