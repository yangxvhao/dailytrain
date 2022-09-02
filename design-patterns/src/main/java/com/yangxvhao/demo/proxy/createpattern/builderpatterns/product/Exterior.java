package com.yangxvhao.demo.proxy.createpattern.builderpatterns.product;

/**
 * 复杂产品
 * 包含多个组成部件
 * @author yangxvhao
 * @date 18-1-17.
 */

public class Exterior {
    private String menu;
    private String playList;
    private String mainWindow;
    private String controlBar;

    public String getMenu() {
        return menu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public String getPlayList() {
        return playList;
    }

    public void setPlayList(String playList) {
        this.playList = playList;
    }

    public String getMainWindow() {
        return mainWindow;
    }

    public void setMainWindow(String mainWindow) {
        this.mainWindow = mainWindow;
    }

    public String getControlBar() {
        return controlBar;
    }

    public void setControlBar(String controlBar) {
        this.controlBar = controlBar;
    }

    @Override
    public String toString() {
        return "Exterior{" +
                "menu='" + menu + '\'' +
                ", playList='" + playList + '\'' +
                ", mainWindow='" + mainWindow + '\'' +
                ", controlBar='" + controlBar + '\'' +
                '}';
    }
}
