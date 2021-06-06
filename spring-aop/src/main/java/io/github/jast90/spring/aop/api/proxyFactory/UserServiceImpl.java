package io.github.jast90.spring.aop.api.proxyFactory;

public class UserServiceImpl implements UserService{
    @Override
    public void findUser() {
        System.out.println("findUser");
    }
}
