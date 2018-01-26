package com.yangxvhao.demo.structuralpattern.compositepattern;

/**
 * Sunny软件公司欲开发一个界面控件库，界面控件分为两大类，一类是单元控件，
 * 例如按钮、文本框等，一类是容器控件，例如窗体、中间面板等，试用组合模式设计该界面控件库。
 * @author yangxvhao
 * @date 18-1-25.
 */

public class Client {
    public static void main(String[] args) {
        AbstractControlLib controlLib = new ContainerControl();
        AbstractControlLib controlLib0 = new ContainerControl();
        AbstractControlLib controlLib1 = new ButtonControl();
        AbstractControlLib controlLib2 = new TxtBoxControl();
        AbstractControlLib controlLib3 = new ButtonControl();
        controlLib.add(controlLib1);
        controlLib.add(controlLib2);
        controlLib.add(controlLib0);
        controlLib0.add(controlLib3);
        controlLib.display();
    }
}
