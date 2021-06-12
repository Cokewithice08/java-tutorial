package cn.jast.spring.lifecycle.component;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

/**
 * Created by jast90 on 2021/5/31
 */
public class ABean {

    @Value("${hello:hello default}")
    private String hello;

    private String name;

    private FullBean fullBean;

    public FullBean getFullBean() {
        return fullBean;
    }

    @Autowired
    public void setFullBean(FullBean fullBean) {
        System.out.println("set full bean");
        this.fullBean = fullBean;
    }

    public String getHello() {
        return hello;
    }

    public void setHello(String hello) {
        this.hello = hello;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
