package com.example.will.demo;

import java.io.IOException;
import java.util.UUID;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Component;

@Component
@WebFilter(filterName = "RequestIdFilter")
public class RequestIdFilter implements Filter {

  @Override
  public void init(FilterConfig filterConfig) throws ServletException {

  }

  @Override
  public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
    String requestId = ((HttpServletRequest)request).getHeader("x-request-id");
    System.out.println("=====RequestIdFilter=======requestId : " + requestId);
  }

  @Override
  public void destroy() {

  }

}
