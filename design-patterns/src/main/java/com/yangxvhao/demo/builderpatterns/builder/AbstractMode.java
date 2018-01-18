package com.yangxvhao.demo.builderpatterns.builder;

import com.yangxvhao.demo.builderpatterns.product.Exterior;

/**
 * 抽象建造者
 * @author yangxvhao
 * @date 18-1-17.
 */

public abstract class AbstractMode {

    protected Exterior exterior = new Exterior();

    public abstract void buildMenu();

    public abstract void buildPlayList();

    public abstract void buildMainWindow();

    public abstract void buildControlBar();

    public boolean isHasMenu(){
        return true;
    }

    public boolean isHasPlayList(){
        return true;
    }

    public boolean isHasMainWindow(){
        return true;
    }

    public boolean isHasControlBar(){
        return true;
    }

    public Exterior getResult(){
        return exterior;
    }
}
