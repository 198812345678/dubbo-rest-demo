package com.example.will.demo;

import com.alibaba.fastjson.JSON;

public class Doc {

    private Long docId;

    public Long getDocId() {
        return docId;
    }

    public void setDocId(Long docId) {
        this.docId = docId;
    }

    public static Doc valueOf(String str) {
        return JSON.parseObject(str, Doc.class);
    }

    @Override
    public String toString() {
        return "Doc{" +
                "docId=" + docId +
                '}';
    }
}
