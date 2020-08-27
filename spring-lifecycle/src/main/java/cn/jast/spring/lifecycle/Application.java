package cn.jast.spring.lifecycle;

import cn.jast.spring.lifecycle.component.FullBean;
import cn.jast.spring.lifecycle.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(SpringConfig.class);
        context.refresh();
        FullBean fullBean = context.getBean("fullBean",FullBean.class);
        fullBean.hello();
        context.close();
    }
}
