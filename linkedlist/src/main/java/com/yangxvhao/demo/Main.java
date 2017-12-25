package com.yangxvhao.demo;

/**
 * @author yangxvhao
 * @date 17-12-25.
 */

public class Main {
    public static void main(String[] args) throws Exception {
        SortList<Integer> linkedList = new SortList<Integer>();
        linkedList.insert(1);
        linkedList.insert(4);
        linkedList.insert(3);
        linkedList.insert(2);
        linkedList.display();
//        linkedList.displayReverse();
        linkedList.delete(4);
        linkedList.display();
    }
}
