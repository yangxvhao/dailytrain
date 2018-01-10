package com.yangxvhao.demo.simplefactorypatterns;

import com.yangxvhao.demo.simplefactorypatterns.factory.SimpleFactory;
import com.yangxvhao.demo.simplefactorypatterns.product.Chart;

/**
 * @author yangxvhao
 * @date 18-1-8.
 */

public class Client {
    public static void main(String[] args) {
        Chart chart = SimpleFactory.getChart("piechart");
        chart.displsy();
    }
}
