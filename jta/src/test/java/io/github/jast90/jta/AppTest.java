package io.github.jast90.jta;

import io.github.jast90.jta.config.SpringConfig;
import io.github.jast90.jta.service.IJTAService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@ContextConfiguration(classes = SpringConfig.class)
public class AppTest {

    @Autowired
    private IJTAService jtaService;


    @Test
    public void test(){
        jtaService.save();
    }
}
