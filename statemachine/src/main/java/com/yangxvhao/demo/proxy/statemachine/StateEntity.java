package com.yangxvhao.demo.proxy.statemachine;

/**
 * Created by yangxvhao on 17-8-29.
 */

/**
 * 实体类
 */
public interface StateEntity {
    /**
     * 获取唯一ID
     * @return
     */
    Integer getId();

    /**
     * 获取状态
     * @return
     */
    Integer getStatus();

    /**
     * 设置状态
     */
    void setStatus(Integer status);
}
