package com.example.will.demo;

public class BaseResponse<T> {

  private int code;

  private String desc;

  private T data;

  public int getCode() {
    return code;
  }

  public void setCode(int code) {
    this.code = code;
  }

  public String getDesc() {
    return desc;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }

  public Object getData() {
    return data;
  }

  public void setData(T data) {
    this.data = data;
  }

  public static BaseResponse buildResp(Object data) {
    BaseResponse baseResponse = new BaseResponse<>();
    baseResponse.setData(data);
    return baseResponse;
  }
}
