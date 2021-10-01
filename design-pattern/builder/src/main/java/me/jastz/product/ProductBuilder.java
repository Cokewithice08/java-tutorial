package me.jastz.product;

/**
 * @author zhiwen
 */
public interface ProductBuilder {
    void buildPartA();

    void buildPartB();

    void buildPartC();

    Product getProduct();
}
