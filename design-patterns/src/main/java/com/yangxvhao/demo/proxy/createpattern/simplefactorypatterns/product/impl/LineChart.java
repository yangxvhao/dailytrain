package com.yangxvhao.demo.proxy.createpattern.simplefactorypatterns.product.impl;

import com.yangxvhao.demo.proxy.createpattern.simplefactorypatterns.product.Chart;

/**
 * 具体产品类
 * @author yangxvhao
 * @date 18-1-8.
 */

public class LineChart implements Chart {

    public LineChart(){
        //创建折线图
        System.out.println("create a lineChart!");
    }

    @Override
    public void displsy() {
        System.out.println("display a lineChart");
    }
}
