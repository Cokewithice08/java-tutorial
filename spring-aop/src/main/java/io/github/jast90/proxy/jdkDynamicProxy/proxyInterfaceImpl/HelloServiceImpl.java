package io.github.jast90.proxy.jdkDynamicProxy.proxyInterfaceImpl;

public class HelloServiceImpl implements HelloService{
    @Override
    public void hello() {
        System.out.println("hello jdk dynamic proxy.");
    }
}
