package com.yangxvhao.demo;

/**
 * 冒泡排序
 * @author yangxvhao
 * @date 2018-11-03 上午12:42.
 */
public class Main {
    public static Integer[] sort(Integer... param){
        for (int i = 0; i < param.length; i++) {
            for (int j = 1; j < param.length; j++) {
                if(param[i] > param[j]){
                    int temp = param[i];
                    param[i] = param[j];
                    param[j] = param[i];
                }
            }
        }
        
        return param;
    } 
    
    public static void main(String[] args) {
        
    }
}
