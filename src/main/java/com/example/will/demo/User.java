package com.example.will.demo;

import com.alibaba.fastjson.JSON;

public class User {

    private Long aLong;

    public User(String str) {
        this.aLong = aLong;
    }

    public Long getaLong() {
        return aLong;
    }

    public void setaLong(Long aLong) {
        this.aLong = aLong;
    }

    public static User valueOf(String str) {
        return JSON.parseObject(str, User.class);
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + aLong +
                '}';
    }
}
