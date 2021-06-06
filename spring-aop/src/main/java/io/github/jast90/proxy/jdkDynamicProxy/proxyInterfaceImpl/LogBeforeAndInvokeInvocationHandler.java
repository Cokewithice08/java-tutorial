package io.github.jast90.proxy.jdkDynamicProxy.proxyInterfaceImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class LogBeforeAndInvokeInvocationHandler implements InvocationHandler {
    private Object target;

    public LogBeforeAndInvokeInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("before...");
        Object invoke = method.invoke(target,args);
        return null;
    }
}
