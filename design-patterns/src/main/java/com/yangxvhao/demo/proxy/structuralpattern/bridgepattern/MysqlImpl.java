package com.yangxvhao.demo.proxy.structuralpattern.bridgepattern;

/**
 * 具体实现类
 * 从mysql数据库获取数据
 * @author yangxvhao
 * @date 18-1-25.
 */

public class MysqlImpl implements DatabaseImpl {
    @Override
    public StingStream getData() {
        System.out.println("从mysql数据库获取数据");
        return new StingStream();
    }
}
