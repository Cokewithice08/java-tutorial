package me.jastz.product;

/**
 * @author zhiwen
 */
public class ConcreteProductBuilder implements ProductBuilder {

    private Product product = new Product();

    @Override
    public void buildPartA() {
        product.setPartA("组件A");
        System.out.println("构建组件A");
    }

    @Override
    public void buildPartB() {
        product.setPartB("组件B");
        System.out.println("构建组件B");
    }

    @Override
    public void buildPartC() {
        product.setPartC("组件C");
        System.out.println("构建组件C");
    }

    @Override
    public Product getProduct() {
        return product;
    }
}
