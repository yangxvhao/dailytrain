package com.yangxvhao.demo.proxy.createpattern.builderpatterns.builder.impl;

import com.yangxvhao.demo.proxy.createpattern.builderpatterns.builder.AbstractMode;

/**
 * @author yangxvhao
 * @date 18-1-18.
 */

public class SimplifyMode extends AbstractMode {
    @Override
    public void buildMenu() {

    }

    @Override
    public void buildPlayList() {

    }

    @Override
    public void buildMainWindow() {
        exterior.setMainWindow("主窗口");
    }

    @Override
    public void buildControlBar() {
        exterior.setControlBar("控制条");
    }

    @Override
    public boolean isHasMenu() {
        return false;
    }
}
