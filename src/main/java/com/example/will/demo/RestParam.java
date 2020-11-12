package com.example.will.demo;

import com.alibaba.fastjson.JSON;

import java.lang.reflect.ParameterizedType;

public class RestParam<T> {

    public RestParam() {
    }

    public T valueOf(String str) {
        Class<T> aClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
        return JSON.parseObject(str, aClass);
    }


}
