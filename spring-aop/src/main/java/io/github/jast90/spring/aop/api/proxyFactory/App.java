package io.github.jast90.spring.aop.api.proxyFactory;

import org.springframework.aop.framework.ProxyFactory;

public class App {
    public static void main(String[] args) {
        System.getProperties().setProperty("sun.misc.ProxyGenerator.saveGeneratedFiles","true");
        proxyInterface();
//        proxyClass();
    }


    /**
     * 代理接口
     */
    public static void proxyInterface(){
        ProxyFactory factory = new ProxyFactory();
        factory.setTarget(new UserServiceImpl());
        factory.setInterfaces(new Class[]{UserService.class});
        factory.addAdvice(new LogBeforeAdvice());
        factory.addAdvice(new LogAfterAdvice());
        UserService userService = (UserService) factory.getProxy();
        userService.findUser();
    }

    public static void proxyClass(){
        ProxyFactory factory = new ProxyFactory();
        factory.setProxyTargetClass(true);
        factory.setTarget(new UserServiceImpl());
        factory.setInterfaces(new Class[]{UserService.class});
        factory.addAdvice(new LogBeforeAdvice());
        factory.addAdvice(new LogAfterAdvice());
        UserService userService = (UserService) factory.getProxy();
        userService.findUser();
    }
}
