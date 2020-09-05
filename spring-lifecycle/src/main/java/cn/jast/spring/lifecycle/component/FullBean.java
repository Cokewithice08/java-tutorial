package cn.jast.spring.lifecycle.component;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.*;

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
public class FullBean implements BeanNameAware, BeanClassLoaderAware, BeanFactoryAware, InitializingBean, DisposableBean {
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
}
