package com.yangxvhao.demo.proxy.structuralpattern.adapterpattern.oasystem;

/**
 * 适配器
 * @author yangxvhao
 * @date 18-1-22.
 */

public class Adapter implements DataOperate{
    private Encrypt encrypt;

    public Adapter() {
        encrypt = new Encrypt();
    }


    @Override
    public void save(String data) {
        System.out.println("保存数据：" + encrypt.md5Encrypt(data));
    }

    @Override
    public void delete(String key) {
        encrypt.aesEncrypt(key);
    }
}
