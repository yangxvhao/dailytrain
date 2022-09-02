package com.yangxvhao.demo.proxy.structuralpattern.adapterpattern.scoreoperation;

/**
 * 适配器
 * @author yangxvhao
 * @date 18-1-19.
 */

public class Adapter implements ScoreOperation{

    private QuickSort quickSort;

    private BinarySearch binarySearch;

    public Adapter() {
        quickSort = new QuickSort();
        binarySearch = new BinarySearch();
    }

    public Adapter(QuickSort quickSort, BinarySearch binarySearch) {
        this.quickSort = quickSort;
        this.binarySearch = binarySearch;
    }

    @Override
    public void sort(int[] score) {
        quickSort.quickSort(score);
    }

    @Override
    public void search(int[] scores, int score) {
        binarySearch.binarySearch(scores, score);
    }
}
