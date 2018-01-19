package com.yangxvhao.demo.structuralpattern.adapterpattern.scoreoperation;

/**
 * 被适配者
 * @author yangxvhao
 * @date 18-1-19.
 */

interface ScoreOperation {
    /**
     * 排序
     * @param score
     */
    void sort(int[] score);

    /**
     * 查找
     * @param scores
     * @param score
     */
    void search(int[] scores, int score);
}
