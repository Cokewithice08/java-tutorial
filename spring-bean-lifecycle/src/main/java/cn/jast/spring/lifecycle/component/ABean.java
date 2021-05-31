package cn.jast.spring.lifecycle.component;

import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by jast90 on 2021/5/31
 */
public class ABean {

    private FullBean fullBean;

    public FullBean getFullBean() {
        return fullBean;
    }

    @Autowired
    public void setFullBean(FullBean fullBean) {
        System.out.println("set full bean");
        this.fullBean = fullBean;
    }
}
