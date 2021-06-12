package io.github.jast90.spring.lifecycle;

import io.github.jast90.spring.lifecycle.component.FullBean;
import io.github.jast90.spring.lifecycle.config.SpringConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { SpringConfig.class })
public class MyTest {
    @Autowired
    private FullBean fullBean;

    @Test
    public void test(){
        fullBean.hello();
    }
}
