package com.yangxvhao.demo.proxy.createpattern.abstractfactorypatterns.product.impl;

import com.yangxvhao.demo.proxy.createpattern.abstractfactorypatterns.product.OperationController;

/**
 * @author yangxvhao
 * @date 18-1-9.
 */

public class WPOperationController implements OperationController {
    @Override
    public void operate() {
        System.out.println("windows phone operation controller");
    }
}
