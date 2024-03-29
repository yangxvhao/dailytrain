package com.yangxvhao.demo.proxy.createpattern.builderpatterns;

import com.yangxvhao.demo.proxy.createpattern.builderpatterns.builder.impl.SimplifyMode;
import com.yangxvhao.demo.proxy.createpattern.builderpatterns.director.ModeController;
import com.yangxvhao.demo.proxy.createpattern.builderpatterns.product.Exterior;

/**
 * @author yangxvhao
 * @date 18-1-18.
 */

public class Client {
    public static void main(String[] args) {
        ModeController controller = new ModeController();
//        CompleteModeBuilder builder = new CompleteModeBuilder();
        SimplifyMode builder = new SimplifyMode();
        Exterior exterior = controller.createMode(builder);
        System.out.println(exterior.toString());
    }
}
