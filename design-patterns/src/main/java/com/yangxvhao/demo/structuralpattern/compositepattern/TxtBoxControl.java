package com.yangxvhao.demo.structuralpattern.compositepattern;

/**
 * 叶子构件
 * @author yangxvhao
 * @date 18-1-26.
 */

public class TxtBoxControl extends AbstractControlLib {
    /**
     * 叶子构件要实现大量无用的方法
     * 可以使用安全组合模式
     * @param controlLib
     */
    @Override
    public void add(AbstractControlLib controlLib) {
        System.out.println("不支持此方法．");
    }

    @Override
    public void remove(AbstractControlLib controlLib) {
        System.out.println("不支持此方法．");
    }

    @Override
    public AbstractControlLib getChild(int i) {
        System.out.println("不支持此方法．");
        return null;
    }

    @Override
    public void display() {
        System.out.println("一个文本框．");
    }
}
