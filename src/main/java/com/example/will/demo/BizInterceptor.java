package com.example.will.demo;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.ext.Provider;
import javax.ws.rs.ext.ReaderInterceptor;
import javax.ws.rs.ext.ReaderInterceptorContext;
import javax.ws.rs.ext.WriterInterceptor;
import javax.ws.rs.ext.WriterInterceptorContext;
import org.apache.commons.io.IOUtils;

public class BizInterceptor implements WriterInterceptor, ReaderInterceptor {

  @Override
  public Object aroundReadFrom(ReaderInterceptorContext context) throws IOException, WebApplicationException {
    byte[] buffer = IOUtils.toByteArray(context.getInputStream());
    System.out.println("The contents of request body is: \n" + new String(buffer, StandardCharsets.UTF_8) + "\n");
    context.setInputStream(new ByteArrayInputStream(buffer));
    return context.proceed();
  }

  @Override
  public void aroundWriteTo(WriterInterceptorContext context) throws IOException, WebApplicationException {
    context.proceed();
    System.out.println("The response");
  }
}
