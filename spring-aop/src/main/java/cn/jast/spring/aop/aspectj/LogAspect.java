package cn.jast.spring.aop.aspectj;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LogAspect {

    @Pointcut("execution(* cn.jast.spring.aop.service.*.*(..))")
    public void servicePointcut(){}

    @Around("servicePointcut()")
    public Object serviceLog(ProceedingJoinPoint proceedingJoinPoint){
        try {
            System.out.println("log start");
            long start = System.currentTimeMillis();
            Object result = proceedingJoinPoint.proceed();
            System.out.println("log end,coast time:"+(System.currentTimeMillis()-start));
            return result;
        } catch (Throwable throwable) {
            throw new RuntimeException();
        }
    }

}
