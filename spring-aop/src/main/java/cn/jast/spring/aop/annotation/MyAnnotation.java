package cn.jast.spring.aop.annotation;

import java.lang.annotation.*;

/**
 * Created by jast90 on 2021/5/31
 */
@Inherited
@Target({ElementType.METHOD,ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface MyAnnotation {
}
