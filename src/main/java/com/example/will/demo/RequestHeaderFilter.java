package com.example.will.demo;

import com.alibaba.fastjson.JSON;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Cookie;
import org.apache.dubbo.rpc.RpcContext;
import org.springframework.util.AntPathMatcher;
import org.springframework.util.PathMatcher;

public class RequestHeaderFilter implements ContainerRequestFilter, ContainerResponseFilter {

  private static final PathMatcher pathMatcher = new AntPathMatcher();

  private static final List<String> URL_PATTERNS = new ArrayList<String>(Arrays.asList("/users/**"));

  @Context
  private HttpServletRequest servletRequest;

  @Override
  public void filter(ContainerRequestContext requestContext) throws IOException {
    String path = requestContext.getUriInfo().getRequestUri().getPath();

    Map<String, Cookie> cookies = requestContext.getCookies();
    System.out.println("=============cookies: " + JSON.toJSONString(cookies));

    RpcContext.getContext().setRequest(requestContext.getRequest());

    RpcContext.getContext().set("cookies", cookies);

    boolean match = false;
    for (String urlPattern : URL_PATTERNS) {
      if (pathMatcher.match(urlPattern, path)) {
        match = true;
        break;
      }
    }

    if (!match) {
      return;
    }
    System.out.println(path);
    String requestId = requestContext.getHeaderString("x-request-id");
    System.out.println("============requestId : " + requestId);
  }

  @Override
  public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
    System.out.println("============response : ");
  }
}
