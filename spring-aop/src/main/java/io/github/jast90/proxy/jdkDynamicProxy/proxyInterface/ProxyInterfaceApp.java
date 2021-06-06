package io.github.jast90.proxy.jdkDynamicProxy.proxyInterface;

import java.lang.reflect.Proxy;

public class ProxyInterfaceApp {
    public static void main(String[] args) {
        UserMapper userMapper = (UserMapper) Proxy.newProxyInstance(UserMapper.class.getClassLoader(),
                new Class[]{UserMapper.class},
                new DBHandler());
        User user = userMapper.find();
        System.out.println(user);
    }
}
