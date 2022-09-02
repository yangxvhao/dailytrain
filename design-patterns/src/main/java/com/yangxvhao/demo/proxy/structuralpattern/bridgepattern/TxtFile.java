package com.yangxvhao.demo.proxy.structuralpattern.bridgepattern;

/**
 * 扩展抽象类
 * 保存为txt格式文件
 * @author yangxvhao
 * @date 18-1-25.
 */

public class TxtFile extends AbstractFile {
    @Override
    public void save2File(String fileName) {
        System.out.println("保存为txt文件,文件名：" + fileName);
    }
}
