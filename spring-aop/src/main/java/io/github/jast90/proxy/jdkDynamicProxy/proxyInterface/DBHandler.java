package io.github.jast90.proxy.jdkDynamicProxy.proxyInterface;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class DBHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Class<?> returnType = method.getReturnType();
        Constructor<?> constructor = returnType.getConstructor();
        Object o = constructor.newInstance();
        return o;
    }
}
