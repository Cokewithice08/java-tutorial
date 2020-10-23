package cn.jast.spring.cicular.dependencies.component;

import org.springframework.beans.factory.annotation.Autowired;

public class Bean2 {

    @Autowired
    private Bean1 bean1;
}
