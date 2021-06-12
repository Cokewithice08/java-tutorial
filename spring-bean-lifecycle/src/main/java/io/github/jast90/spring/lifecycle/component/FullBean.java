package io.github.jast90.spring.lifecycle.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;
import org.springframework.context.*;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ResourceLoader;
import org.springframework.util.StringValueResolver;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

/**
 * FullBean的初始化及销毁：
 * FullBean constructor
 * setHello
 * CustomerBeanPostProcessor.postProcessBeforeInitialization,beanName=aBean
 * CustomerBeanPostProcessor.postProcessAfterInitialization,beanName=aBean
 * set aBean
 * FullBean BeanNameAware.setBeanName
 * FullBean BeanClassLoaderAware.setBeanClassLoader
 * FullBean BeanFactoryAware.setBeanFactory
 * CustomerBeanPostProcessor.postProcessBeforeInitialization,beanName=fullBean
 * FullBean @PostConstruct 标注的方法
 * FullBean InitializingBean.afterPropertiesSet
 * FullBean custom init
 * CustomerBeanPostProcessor.postProcessAfterInitialization,beanName=fullBean
 * hello
 * FullBean @PreDestroy 标注的方法
 * FullBean DisposableBean.destroy
 * FullBean custom destory
 */
public class FullBean implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, EnvironmentAware,
        EmbeddedValueResolverAware, ResourceLoaderAware, ApplicationEventPublisherAware, MessageSourceAware,
        ApplicationContextAware,InitializingBean, DisposableBean {

    public static final Logger logger = LoggerFactory.getLogger(FullBean.class);

    private String hello;

    private ABean aBean;

    public FullBean() {
        logger.debug("FullBean constructor");
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        logger.debug("setHello");
        this.hello = hello;
    }

    public ABean getaBean() {
        return aBean;
    }

    public void setaBean(ABean aBean) {
        logger.debug("set aBean");
        this.aBean = aBean;
    }

    public void setBeanClassLoader(ClassLoader classLoader) {
        logger.debug("FullBean BeanClassLoaderAware.setBeanClassLoader");
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        logger.debug("FullBean BeanFactoryAware.setBeanFactory");
    }

    public void setBeanName(String s) {
        logger.debug("FullBean BeanNameAware.setBeanName");
    }

    public void destroy() throws Exception {
        logger.debug("FullBean DisposableBean.destroy");
    }

    public void afterPropertiesSet() throws Exception {
        logger.debug("FullBean InitializingBean.afterPropertiesSet");
    }
    public void hello(){
        logger.debug("hello");
    }

    public void customInit(){
        logger.debug("FullBean custom init");
    }

    public void customDestroy(){
        logger.debug("FullBean custom destory");
    }

    @PostConstruct
    public void initPostConstruct(){
        logger.debug("FullBean @PostConstruct 标注的方法");
    }

    @PreDestroy
    public void preDestroy(){
        logger.debug("FullBean @PreDestroy 标注的方法");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        logger.debug("ApplicationContextAware.setApplicationContext");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        logger.debug("ApplicationEventPublisherAware.setApplicationEventPublisher");
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        logger.debug("EmbeddedValueResolverAware.setEmbeddedValueResolver");
    }

    @Override
    public void setEnvironment(Environment environment) {
        logger.debug("EnvironmentAware.setEnvironment");
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        logger.debug("MessageSourceAware.setMessageSource");
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        logger.debug("ResourceLoaderAware.setResourceLoader");
    }
}
