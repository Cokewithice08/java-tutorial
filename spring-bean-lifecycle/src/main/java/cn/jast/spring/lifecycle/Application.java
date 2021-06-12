package cn.jast.spring.lifecycle;

import cn.jast.spring.lifecycle.component.ABean;
import cn.jast.spring.lifecycle.component.FullBean;
import cn.jast.spring.lifecycle.config.SpringConfig;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Application {

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
        FullBean fullBean = context.getBean("fullBean",FullBean.class);
        fullBean.hello();
        System.out.println(fullBean.getClass().getName());
        ABean abean = context.getBean("aBean", ABean.class);
        System.out.println("ABean.hello:" + abean.getHello());
        System.out.println("ABean.name:" + abean.getName());

        //自定义facotryBean
        FactoryBean<String> bean = context.getBean("&myBeanFactoryBean", FactoryBean.class);
        System.out.println(bean.getClass().getName());
        String object = bean.getObject();
        System.out.println(object);
        context.destroy();
    }
}
