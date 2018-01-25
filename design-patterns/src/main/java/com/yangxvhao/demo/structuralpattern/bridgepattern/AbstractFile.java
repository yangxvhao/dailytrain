package com.yangxvhao.demo.structuralpattern.bridgepattern;

/**
 * 抽象类
 * @author yangxvhao
 * @date 18-1-25.
 */
public abstract class AbstractFile {
    protected DatabaseImpl impl;

    public DatabaseImpl getImpl() {
        return impl;
    }

    public void setImpl(DatabaseImpl impl) {
        this.impl = impl;
    }

    /**
     * 保存为各种格式文件
     * @param fileName
     */
    public abstract void save2File(String fileName);
}
