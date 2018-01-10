package com.yangxvhao.demo.simplefactorypatterns.product.impl;

import com.yangxvhao.demo.simplefactorypatterns.product.Chart;

/**
 * 具体产品类
 * @author yangxvhao
 * @date 18-1-8.
 */

public class PieChart implements Chart {
    public PieChart(){
        //创建饼状图
        System.out.println("create a pieChart");
    }

    @Override
    public void displsy() {
        System.out.println("display a pieChart");
    }
}
