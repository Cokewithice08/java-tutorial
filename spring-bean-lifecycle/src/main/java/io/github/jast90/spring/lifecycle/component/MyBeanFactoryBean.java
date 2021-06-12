package io.github.jast90.spring.lifecycle.component;

import org.springframework.beans.factory.FactoryBean;

import java.util.UUID;


public class MyBeanFactoryBean implements FactoryBean<String> {
    @Override
    public String getObject() throws Exception {
        return UUID.randomUUID().toString();
    }

    @Override
    public Class<?> getObjectType() {
        return String.class;
    }

    @Override
    public boolean isSingleton() {
        return true;
    }
}
