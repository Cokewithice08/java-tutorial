package me.jastz.pay;

/**
 * 抽象支付工厂（抽象工厂）
 *
 * @author zhiwen
 */
public interface PayFactory {
    Pay getPay();
}
