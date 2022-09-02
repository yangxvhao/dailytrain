package com.yangxvhao.demo.proxy.createpattern.builderpatterns.director;

import com.yangxvhao.demo.proxy.createpattern.builderpatterns.builder.AbstractMode;
import com.yangxvhao.demo.proxy.createpattern.builderpatterns.product.Exterior;

/**
 * 指挥者，
 * 负责安排复杂对象的建造次序
 * 可以简化，放到抽象建造者里
 * @author yangxvhao
 * @date 18-1-18.
 */

public class ModeController {

    public Exterior createMode(AbstractMode mode){
        if(mode.isHasControlBar()) {
            mode.buildControlBar();
        }
        if(mode.isHasMainWindow()) {
            mode.buildMainWindow();
        }
        if(mode.isHasMenu()) {
            mode.buildMenu();
        }
        if(mode.isHasPlayList()) {
            mode.buildPlayList();
        }
        return mode.getResult();
    }
}
