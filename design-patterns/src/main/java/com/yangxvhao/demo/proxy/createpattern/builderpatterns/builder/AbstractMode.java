package com.yangxvhao.demo.proxy.createpattern.builderpatterns.builder;

import com.yangxvhao.demo.proxy.createpattern.builderpatterns.product.Exterior;

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

    /**
     * 钩子方法
     * 控制是否创建某个部件
     * 更加精准的控制产品的创建过程
     * @return
     */
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
