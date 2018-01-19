package com.yangxvhao.demo.createpattern.simplefactorypatterns.factory;

import com.yangxvhao.demo.createpattern.simplefactorypatterns.product.Chart;
import com.yangxvhao.demo.createpattern.simplefactorypatterns.product.impl.LineChart;
import com.yangxvhao.demo.createpattern.simplefactorypatterns.product.impl.PieChart;

/**
 * 简单工厂方法
 * @author yangxvhao
 * @date 18-1-8.
 */

public class SimpleFactory {
    public static Chart getChart(String type){
        if(type.equalsIgnoreCase("piechart")){
            return new PieChart();
        }
        if(type.equalsIgnoreCase("linechart")){
            return new LineChart();
        }
        return null;
    }
}
