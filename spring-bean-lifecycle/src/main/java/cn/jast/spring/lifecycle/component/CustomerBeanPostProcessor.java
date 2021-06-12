package cn.jast.spring.lifecycle.component;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomerBeanPostProcessor implements BeanPostProcessor {


    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("初始化前 后处理逻辑... 。bean name="+beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        System.out.println("初始化后 后处理逻辑... 。beanName="+beanName);
        return bean;
    }
}
