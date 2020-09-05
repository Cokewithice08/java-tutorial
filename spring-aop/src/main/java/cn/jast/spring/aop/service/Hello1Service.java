package cn.jast.spring.aop.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Hello1Service {
    @Autowired
    private HelloService helloService;

    public void hello1(){
        System.out.println("hello1");
        helloService.hello();
    }
}
