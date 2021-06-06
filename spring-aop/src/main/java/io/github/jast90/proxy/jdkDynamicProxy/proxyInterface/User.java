package io.github.jast90.proxy.jdkDynamicProxy.proxyInterface;

public class User {
    private Long id;
    private String name;

    public User() {
        this.id = 10L;
        this.name = "jast90";
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
