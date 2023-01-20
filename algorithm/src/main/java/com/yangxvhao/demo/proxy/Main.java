package com.yangxvhao.demo.proxy;

import com.yangxvhao.demo.proxy.sort.QuickSort;

/**
 * 排序
 *
 * @author yangxvhao
 * @date 2018-11-03 上午12:42.
 */
public class Main {

    public static void main(String[] args) {
        Integer[] param = {2, 1, 3, 4, 12, 11};
        Integer[] result;
        
//        BubbleSort bubbleSort = new BubbleSort();
//        result = bubbleSort.sort(param);
//        bubbleSort.show(result);
        
//        SelectionSort selectionSort = new SelectionSort();
//        result = selectionSort.sort(param);
//        selectionSort.show(result);

//        InsertionSort insertionSort = new InsertionSort();
//        result = insertionSort.sort(param);
//        insertionSort.show(result);

//        MergeSort mergeSort = new MergeSort();
//        result = mergeSort.sort(param);
//        mergeSort.show(result);

        QuickSort quickSort = new QuickSort();
        result = quickSort.sort(param);
        quickSort.show(result);
    }
}
