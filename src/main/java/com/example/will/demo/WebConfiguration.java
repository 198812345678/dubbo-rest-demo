package com.example.will.demo;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfiguration implements WebMvcConfigurer {

  /**
   * 这个对dubbo提供的rest接口应该不生效，因为dubbo默认使用的容器应该不是springboot内嵌的
   * @return
   */
  @Bean
  public FilterRegistrationBean configureFilter3(){
    FilterRegistrationBean bean = new FilterRegistrationBean<>();
    bean.setName("requestIdFilter");
    RequestIdFilter myfilter = new RequestIdFilter();
    bean.setFilter(myfilter);
    bean.addUrlPatterns("/users/registerget/2");
    bean.setOrder(1);
    return bean;
  }
}
