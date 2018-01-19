package com.yangxvhao.demo.createpattern.abstractfactorypatterns;

import com.yangxvhao.demo.createpattern.abstractfactorypatterns.factory.OperatingSystemFactory;
import com.yangxvhao.demo.createpattern.abstractfactorypatterns.factory.impl.WindowsPhoneFactory;

/**
 * @author yangxvhao
 * @date 18-1-9.
 */

public class Client {
    public static void main(String[] args) {
        OperatingSystemFactory factory = null;
//        factory = new AndroidFactory();
        factory = new WindowsPhoneFactory();
        factory.createIc().display();
        factory.createOc().operate();
    }
}
