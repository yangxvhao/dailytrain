package com.yangxvhao.demo.proxy.structuralpattern.compositepattern;

/**
 * 叶子构件
 * @author yangxvhao
 * @date 18-1-26.
 */

public class ButtonControl extends AbstractControlLib {
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
        System.out.println("一个按钮．");
    }
}
