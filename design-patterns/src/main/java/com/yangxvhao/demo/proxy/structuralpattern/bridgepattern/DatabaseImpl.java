package com.yangxvhao.demo.proxy.structuralpattern.bridgepattern;

/**
 * 实现类
 * @author yangxvhao
 * @date 18-1-25.
 */

public interface DatabaseImpl {
    /**
     * 获取数据
     * @return
     */
    StingStream getData();
}
