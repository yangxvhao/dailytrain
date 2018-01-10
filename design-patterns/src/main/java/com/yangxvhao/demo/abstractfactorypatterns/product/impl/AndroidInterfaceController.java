package com.yangxvhao.demo.abstractfactorypatterns.product.impl;

import com.yangxvhao.demo.abstractfactorypatterns.product.InterfaceController;

/**
 * @author yangxvhao
 * @date 18-1-9.
 */

public class AndroidInterfaceController implements InterfaceController {
    @Override
    public void display() {
        System.out.println("android interface controller");
    }
}
