package com.myapplication;

/**
 * Created by tedliang on 2016/9/10.
 */
public class User {
    private String name;
    private String tel;

    public User(String name, String tel, String addr) {
        this.name = name;
        this.tel = tel;
        this.addr = addr;
    }

    public String getName() {

        return name;
    }

    public String getTel() {
        return tel;
    }

    public String getAddr() {
        return addr;
    }

    private String addr;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", tel='" + tel + '\'' +
                ", addr='" + addr + '\'' +
                '}';
    }
}
