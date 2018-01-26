package com.yangxvhao.demo.structuralpattern.compositepattern;

import java.util.ArrayList;
import java.util.List;

/**
 * 容器构件
 * @author yangxvhao
 * @date 18-1-26.
 */

public class ContainerControl extends AbstractControlLib {
    private List<AbstractControlLib> controlLibList;

    public ContainerControl() {
        controlLibList = new ArrayList<>();
    }

    @Override
    public void add(AbstractControlLib controlLib) {
        controlLibList.add(controlLib);
    }

    @Override
    public void remove(AbstractControlLib controlLib) {
        controlLibList.remove(controlLib);
    }

    @Override
    public AbstractControlLib getChild(int i) {
        return controlLibList.get(i);
    }

    @Override
    public void display() {
        System.out.print("一个容器，包含：");
        for (AbstractControlLib controlLib : controlLibList) {
            controlLib.display();
        }
    }
}
