package cn.jast.spring.aop.service;

import org.springframework.stereotype.Service;

@Service
public class HelloService {

    public void hello(){
        System.out.println("Hello");
    }


}
