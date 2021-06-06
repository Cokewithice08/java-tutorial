package io.github.jast90.spring.aop.usage.component;

import io.github.jast90.spring.aop.usage.annotation.MyAnnotation;
import org.springframework.stereotype.Component;

/**
 * Created by jast90 on 2021/5/31
 */
@Component
@MyAnnotation
public class MyAnnotationComponent {

    @MyAnnotation
    public void helloMyAnnotation(){
        System.out.println("Hello my annotation");
    }
}
