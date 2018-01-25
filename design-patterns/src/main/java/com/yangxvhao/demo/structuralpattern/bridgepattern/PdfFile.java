package com.yangxvhao.demo.structuralpattern.bridgepattern;

/**
 * 扩充抽象类
 * 保存为pdf格式文件
 * @author yangxvhao
 * @date 18-1-25.
 */

public class PdfFile extends AbstractFile {
    @Override
    public void save2File(String fileName) {
        StingStream stream = impl.getData();
        System.out.println("保存为pdf文件,文件名：" + fileName);
    }
}
