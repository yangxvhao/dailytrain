package com.yangxvhao.demo.jvm;


import lombok.Data;
import org.openjdk.jol.info.ClassLayout;

/**
 * @author yangxvhao
 * @date 2022-05-24 21:26.
 */
@Data
public class CreateObject {
    private Integer a;
    private T t;
    private class T{

    }


    public static void main(String[] args) {
        CreateObject o = new CreateObject();
        o.setA(1);
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
    }

}
