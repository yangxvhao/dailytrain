package com.yangxvhao.demo.createpattern.prototypepatterns.deepclone;

import java.io.Serializable;

/**
 * @author yangxvhao
 * @date 18-1-10.
 */

public class Address implements Serializable {
    public String country;
    public String city;
    public String detail;

    public Address() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
}
