package cn.jast.spring.aop.aspectj;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

    /**
     * cn.jast.spring.aop.service下所有类的所有方法
     */
    @Pointcut("execution(* cn.jast.spring.aop.service.*.*(..))")
    public void servicePointcut(){}

    /**
     * 包下中类的所有方法 within(cn.jast.spring.aop.service.*)
     * 包下及子包中类的所有方法 within(cn.jast.spring.aop.service..*)
     */
    @Pointcut("within(cn.jast.spring.aop.service..*)")
    public void withinPointcut(){}

    /**
     * 使用注解MyAnnotation注释的所有方法
     */
    @Pointcut("@annotation(cn.jast.spring.aop.annotation.MyAnnotation)")
    public void annotationAnnotationPointcut(){}

    /**
     * 使用注解注释的类中的所有方法
     *
     */
    @Pointcut("@within(cn.jast.spring.aop.annotation.MyAnnotation)")
    public void withinAnnotationPointcut(){}

    @Around("withinPointcut()")
    public Object serviceLog(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("log start");
        long start = System.currentTimeMillis();
        Object result = proceedingJoinPoint.proceed();
        System.out.println("log end,coast time:"+(System.currentTimeMillis()-start));
        return result;

    }

    @Before("withinAnnotationPointcut()")
    public void before(){
        System.out.println("LogAspect before");
    }

    @After("withinPointcut()")
    public void after(){
        System.out.println("LogAspect after");
    }

    @AfterReturning("withinPointcut()")
    public void afterReturning(){
        System.out.println("LogAspect afterReturning");
    }

    @AfterThrowing("withinPointcut()")
    public void afterThrowing(){
        System.out.println("LogAspect AfterThrowing");
    }
}
