package com.yangxvhao.demo.proxy.createpattern.simplefactorypatterns;

import com.yangxvhao.demo.proxy.createpattern.simplefactorypatterns.factory.SimpleFactory;
import com.yangxvhao.demo.proxy.createpattern.simplefactorypatterns.product.Chart;

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
