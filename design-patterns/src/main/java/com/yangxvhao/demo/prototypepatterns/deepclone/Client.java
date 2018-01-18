package com.yangxvhao.demo.prototypepatterns.deepclone;


import java.io.IOException;

/**
 * @author yangxvhao
 * @date 18-1-11.
 */

public class Client {
    public static void main(String[] args) {
        Customer customer, customer1 = null;
        customer = new Customer();
        Address address = new Address();
        customer.setAddress(address);
        customer.setName("tom");

        try {
            customer1 = customer.deepClone();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        System.out.println(customer == customer1);
        System.out.println(customer.getAddress() == customer1.getAddress());
    }
}
