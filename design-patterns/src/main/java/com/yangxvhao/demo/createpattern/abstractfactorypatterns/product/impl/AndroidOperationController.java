package com.yangxvhao.demo.createpattern.abstractfactorypatterns.product.impl;

import com.yangxvhao.demo.createpattern.abstractfactorypatterns.product.OperationController;

/**
 * @author yangxvhao
 * @date 18-1-9.
 */

public class AndroidOperationController implements OperationController {
    @Override
    public void operate() {
        System.out.println("android operate controller");
    }
}
