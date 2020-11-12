package com.example.will.demo.reporttest;

import lombok.Data;

@Data
public class CallbackRequest {

  private boolean success;
  private String taskId;
  private String downloadUrl;

}
