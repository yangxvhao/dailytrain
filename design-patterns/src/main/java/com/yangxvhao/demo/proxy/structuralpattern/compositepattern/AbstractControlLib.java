package com.yangxvhao.demo.proxy.structuralpattern.compositepattern;

/**
 * 抽象构件
 *
 * @author yangxvhao
 * @date 18-1-25.
 */

public abstract class AbstractControlLib {
    /**
     * 添加成员
     * @param controlLib
     */
    public abstract void add(AbstractControlLib controlLib);

    /**
     * 删除成员
     * @param controlLib
     */
    public abstract void remove(AbstractControlLib controlLib);

    /**
     * 获取容器构件的子成员
     * @param i
     * @return
     */
    public abstract AbstractControlLib getChild(int i);

    /**
     * 业务方法
     * 显示控件
     */
    public abstract void display();
}
