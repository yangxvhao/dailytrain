package com.yangxvhao.demo.proxy.structuralpattern.bridgepattern;

/**
 * Sunny软件公司欲开发一个数据转换工具，可以将数据库中的数据转换成多种文件格式，
 * 例如txt、xml、pdf等格式，同时该工具需要支持多种不同的数据库。试使用桥接模式对其进行设计。
 * @author yangxvhao
 * @date 18-1-22.
 */

public class Client {
    public static void main(String[] args) {
        AbstractFile file = new PdfFile();
        DatabaseImpl impl = new MysqlImpl();
        file.setImpl(impl);
        file.save2File("test.pdf");
    }
}
