package com.yangxvhao.demo.structuralpattern.adapterpattern.oasystem;

/**
 * 数据库操作类
 * 被适配者
 * @author yangxvhao
 * @date 18-1-22.
 */

public interface DataOperate {
    /**
     * 数据保存
     * @param data
     */
    void save(String data);

    /**
     * 删除
     * @param key
     */
    void delete(String key);
}
