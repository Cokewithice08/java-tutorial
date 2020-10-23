package cn.jast.spring.cicular.dependencies.component;

import org.springframework.beans.factory.annotation.Autowired;

public class Bean1 {

    @Autowired
    private Bean2 bean2;

}
