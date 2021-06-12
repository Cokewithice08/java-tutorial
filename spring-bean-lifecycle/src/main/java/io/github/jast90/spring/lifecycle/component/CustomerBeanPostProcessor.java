package io.github.jast90.spring.lifecycle.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

@Component
public class CustomerBeanPostProcessor implements BeanPostProcessor {

    public static final Logger logger = LoggerFactory.getLogger(CustomerBeanPostProcessor.class);

    public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {
        logger.debug("初始化前 后处理逻辑... 。bean name="+beanName);
        return bean;
    }

    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        logger.debug("初始化后 后处理逻辑... 。beanName="+beanName);
        return bean;
    }
}
