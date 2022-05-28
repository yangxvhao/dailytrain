package com.yangxvhao.demo.proxy.createpattern.prototypepatterns.shallowclone;

/**
 * @author yangxvhao
 * @date 18-1-10.
 */

public class Client {
    public static void main(String[] args) {
        Customer customer, customer1 = null;
        customer = new Customer();
        customer.setName("tom");
        customer.setAge(20);
        Address address = new Address();
        address.setCity("beijing");
        customer.setAddress(address);

        try {
            customer1 = customer.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        System.out.println(customer == customer1);
        System.out.println(customer.getAddress() == customer1.getAddress());
    }
}
