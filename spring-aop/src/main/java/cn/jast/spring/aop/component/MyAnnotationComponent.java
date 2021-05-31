package cn.jast.spring.aop.component;

import cn.jast.spring.aop.annotation.MyAnnotation;
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
