package io.github.jast90.spring.lifecycle;

import io.github.jast90.spring.lifecycle.component.ABean;
import io.github.jast90.spring.lifecycle.component.FullBean;
import io.github.jast90.spring.lifecycle.config.SpringConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.Arrays;

public class Application {
    public static final Logger logger = LoggerFactory.getLogger(Application.class);

    public static void main(String[] args) throws Exception {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(SpringConfig.class);
//        beanA(context);
        customBeanFactory(context);
    }

    private static void getBeanByClass(AnnotationConfigApplicationContext context ){
        String[] beanNamesForType = context.getBeanNamesForType(BeanPostProcessor.class);
        logger.debug(""+ Arrays.toString(beanNamesForType));
        logger.debug("BeanDefinitionNames:"+Arrays.toString(context.getBeanDefinitionNames()));
    }

    private static void fullBean(AnnotationConfigApplicationContext context ){
        FullBean fullBean = context.getBean("fullBean",FullBean.class);
        fullBean.hello();
        logger.debug(fullBean.getClass().getName());
    }

    private static void beanA(AnnotationConfigApplicationContext context){
        ABean abean = context.getBean("aBean", ABean.class);
        logger.debug("ABean.hello:" + abean.getHello());
        logger.debug("ABean.name:" + abean.getName());
    }

    private static void customBeanFactory(AnnotationConfigApplicationContext context) throws Exception {
        //自定义factoryBean
        FactoryBean<String> bean = context.getBean("&myBeanFactoryBean", FactoryBean.class);
        logger.debug(bean.getClass().getName());
        String object = bean.getObject();
        logger.debug(object);
        logger.debug(bean.getObject());

        Object myBeanFactoryBean = context.getBean("myBeanFactoryBean");
        System.out.println("----------------------"+myBeanFactoryBean);
        System.out.println("----------------------"+context.getBean("myBeanFactoryBean"));
        context.destroy();

    }
}
