package com.yangxvhao.demo.builderpatterns.builder.impl;

import com.yangxvhao.demo.builderpatterns.builder.AbstractMode;

/**
 * 具体建造者
 * @author yangxvhao
 * @date 18-1-18.
 */

public class CompleteModeBuilder extends AbstractMode {
    @Override
    public void buildMenu() {
        exterior.setMenu("菜单");
    }

    @Override
    public void buildPlayList() {
        exterior.setPlayList("播放列表");
    }

    @Override
    public void buildMainWindow() {
        exterior.setMainWindow("主窗口");
    }

    @Override
    public void buildControlBar() {
        exterior.setControlBar("控制条");
    }
}
