package com.yangxvhao.demo.proxy.createpattern.prototypepatterns.shallowclone;

/**
 * 浅克隆
 * 引用类型Address在复制的时候复制的是地址,还是同一个对象
 * @author yangxvhao
 * @date 18-1-10.
 */

public class Customer implements Cloneable{
    public String name;
    public Integer age;
    public Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    @Override
    public Customer clone() throws CloneNotSupportedException {
        return (Customer) super.clone();
    }
}
