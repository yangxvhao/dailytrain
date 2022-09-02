package com.yangxvhao.demo.proxy.structuralpattern.adapterpattern.scoreoperation;

/**
 * Sunny软件公司在很久以前曾开发了一个算法库，里面包含了一些常用的算法，例如排序算法和查找算法，
 * 在进行各类软件开发时经常需要重用该算法库中的算法。在为某学校开发教务管理系统时，
 * 开发人员发现需要对学生成绩进行排序和查找，该系统的设计人员已经开发了一个成绩操作接口ScoreOperation，
 * 在该接口中声明了排序方法sort(int[]) 和查找方法search(int[], int)，为了提高排序和查找的效率，
 * 开发人员决定重用算法库中的快速排序算法类QuickSort和二分查找算法类BinarySearch，
 * 其中QuickSort的quickSort(int[])方法实现了快速排序，BinarySearch 的binarySearch (int[], int)方法实现了二分查找。
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
