package com.yangxvhao.demo.proxy.structuralpattern.adapterpattern.oasystem;

import org.apache.commons.codec.digest.Md5Crypt;

/**
 * 加密类
 * 适配者
 * @author yangxvhao
 * @date 18-1-22.
 */

public class Encrypt {
    /**
     * md5加密
     * @param data
     * @return
     */
    public String md5Encrypt(String data){
        return Md5Crypt.md5Crypt(data.getBytes());
    }

    /**
     * aes加密
     * @param data
     * @return
     */
    public String aesEncrypt(String data){
        return data + "aes";
    }
}
