package cn.jast.spring.lifecycle;

import cn.jast.spring.lifecycle.component.ABean;
import cn.jast.spring.lifecycle.component.FullBean;
import cn.jast.spring.lifecycle.config.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        FullBean fullBean = context.getBean("fullBean",FullBean.class);
        fullBean.hello();
        ABean abean = context.getBean("aBean", ABean.class);
        System.out.println(fullBean.getClass().getName());
        context.destroy();
    }
}
