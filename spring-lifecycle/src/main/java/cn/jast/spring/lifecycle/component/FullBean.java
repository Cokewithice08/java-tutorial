package cn.jast.spring.lifecycle.component;

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
    private String hello;

    public FullBean() {
        System.out.println("\n\n");
        System.out.println("FullBean constructor");
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        System.out.println("setHello");
        this.hello = hello;
    }

    public void setBeanClassLoader(ClassLoader classLoader) {
        System.out.println("FullBean BeanClassLoaderAware.setBeanClassLoader");
    }

    public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
        System.out.println("FullBean BeanFactoryAware.setBeanFactory");
    }

    public void setBeanName(String s) {
        System.out.println("FullBean BeanNameAware.setBeanName");
    }

    public void destroy() throws Exception {
        System.out.println("FullBean DisposableBean.destroy");
    }

    public void afterPropertiesSet() throws Exception {
        System.out.println("FullBean InitializingBean.afterPropertiesSet");
    }
    public void hello(){
        System.out.println("hello");
    }

    public void customInit(){
        System.out.println("FullBean custom init");
    }

    public void customDestroy(){
        System.out.println("FullBean custom destory");
    }

    @PostConstruct
    public void initPostConstruct(){
        System.out.println("FullBean @PostConstruct 标注的方法");
    }

    @PreDestroy
    public void preDestroy(){
        System.out.println("FullBean @PreDestroy 标注的方法");
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        System.out.println("ApplicationContextAware.setApplicationContext");
    }

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        System.out.println("ApplicationEventPublisherAware.setApplicationEventPublisher");
    }

    @Override
    public void setEmbeddedValueResolver(StringValueResolver resolver) {
        System.out.println("EmbeddedValueResolverAware.setEmbeddedValueResolver");
    }

    @Override
    public void setEnvironment(Environment environment) {
        System.out.println("EnvironmentAware.setEnvironment");
    }

    @Override
    public void setMessageSource(MessageSource messageSource) {
        System.out.println("MessageSourceAware.setMessageSource");
    }

    @Override
    public void setResourceLoader(ResourceLoader resourceLoader) {
        System.out.println("ResourceLoaderAware.setResourceLoader");
    }
}
