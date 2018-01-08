package com.yangxvhao.demo.simplefactorypatterns;

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
