package cn.jast.spring.cicular.dependencies.component;


public class BeanA {

    private BeanB b;

    public BeanA(BeanB b) {
        this.b = b;
    }
}
