package io.github.jast90.proxy.jdkDynamicProxy.proxyInterfaceImpl;

import java.lang.reflect.Proxy;

public class JdkDynamicProxyApp {
    public static void main(String[] args) {
        HelloService helloService = (HelloService) Proxy.newProxyInstance(HelloService.class.getClassLoader(),
                new Class[]{HelloService.class},
                new LogBeforeAndInvokeInvocationHandler(new HelloServiceImpl()));
        helloService.hello();
    }
}
