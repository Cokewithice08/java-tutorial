package me.jastz.pay.alipay;

import me.jastz.pay.Pay;
import me.jastz.pay.PayFactory;

/**
 * 支付宝支付 工厂（具体工厂）
 *
 * @author zhiwen
 */
public class AliPayFactory implements PayFactory {
    @Override
    public Pay getPay() {
        return new AliPay();
    }
}
