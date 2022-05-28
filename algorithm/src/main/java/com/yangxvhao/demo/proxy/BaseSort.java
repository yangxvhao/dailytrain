package com.yangxvhao.demo.proxy;

/**
 * @author yangxvhao
 * @date 2018-11-05 上午10:48.
 */
public abstract class BaseSort {
    public Integer[] sort(Integer... param){return param;}
    
    public void show(Integer... param){
        for (Integer integer : param) {
            System.out.print(integer + " ");
        }
    }
}
