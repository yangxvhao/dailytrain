package com.yangxvhao.demo.proxy.loadclass;

import com.yangxvhao.demo.proxy.HelloHandler;

import java.io.IOException;
import java.io.InputStream;

/**
 * 手写一个类加载器
 *
 * @author yangxuhao
 * @date 2019-12-03 14:35.
 */
public class ClassLoadDemo {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        ClassLoader classLoader = new ClassLoader() {
            @Override
            public Class<?> loadClass(String name) throws ClassNotFoundException {
                try {
                    InputStream in = getClass().getResourceAsStream(name.substring(name.lastIndexOf(".") + 1) + ".class");

                    if (in == null) {
                        return super.loadClass(name);
                    }
                    byte[] bytes = new byte[in.available()];
                    in.read(bytes);

                    return defineClass(name, bytes, 0, bytes.length);
                } catch (IOException e) {
                    e.printStackTrace();
                }
                return super.loadClass(name);
            }
        };


        Object helloHandler = classLoader.loadClass("com.yangxvhao.demo.proxy.loadclass.ClassLoadDemo").newInstance();
        System.out.println(helloHandler instanceof HelloHandler);
    }
}
