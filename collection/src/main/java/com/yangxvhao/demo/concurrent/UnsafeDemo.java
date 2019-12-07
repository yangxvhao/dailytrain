package com.yangxvhao.demo.concurrent;

import com.yangxvhao.demo.model.Person;
import jodd.util.ObjectUtil;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.Objects;

/**
 * @author yangxuhao
 * @date 2019-11-28 17:50.
 */
public class UnsafeDemo {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Class p = Person.class;

        Field name = p.getDeclaredField("name");
        name.setAccessible(true);




        Class c = Unsafe.class;
        Field field = c.getDeclaredField("theUnsafe");
        field.setAccessible(true);
        Unsafe unsafe = (Unsafe) field.get(null);
        System.out.println(unsafe);
    }
}
