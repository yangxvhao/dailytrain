package com.yangxvhao.demo.proxy.createpattern.prototypepatterns.deepclone;


import java.io.*;

/**
 * 深克隆
 * @author yangxvhao
 * @date 18-1-11.
 */

public class Customer implements Serializable {
    private String name;
    private String age;
    private Address address;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public Customer deepClone() throws IOException, ClassNotFoundException{
        /**
         * 将对象写入流中
         */
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream);
        objectOutputStream.writeObject(this);

        /**
         *从流中读取对象
         */
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
        ObjectInputStream objectInputStream = new ObjectInputStream(byteArrayInputStream);
        return (Customer) objectInputStream.readObject();
    }
}
