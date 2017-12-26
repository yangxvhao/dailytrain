package com.yangxvhao.demo;

/**
 * @author yangxvhao
 * @date 17-12-19.
 */
public class Main {
    public static void main(String[] args) {
        SkipList<String> skipList = new SkipList<>();
        skipList.insert(1.0,"tom");
        skipList.insert(2.0,"jack");
        skipList.insert(3.0,"jjjj");
        skipList.display();
        skipList.insert(2.0,"kkkk");
        skipList.insert(2.1,"kkkk");
        skipList.insert(2.2,"kkkk");
        skipList.display();
        skipList.delete(2.0);
        skipList.display();
        System.out.println(skipList.get(2.2));
//        int count = 0;
//        int sum = 100000;
//        for(int i = 0; i < sum; i ++) {
//            if(new Random().nextInt() % 2 == 0){
//                count ++;
//            }
//
//        }
//        System.out.println((count * 1.0)/sum);
    }
}
