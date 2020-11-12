package com.example.will.demo;


import org.apache.dubbo.config.annotation.DubboService;
import org.springframework.stereotype.Component;

@DubboService(interfaceClass = HelloService.class, protocol = {"hessian"})
@Component
public class HelloServiceImpl implements HelloService {

    @Override
    public String sayHello() {
        return null;
    }
}
