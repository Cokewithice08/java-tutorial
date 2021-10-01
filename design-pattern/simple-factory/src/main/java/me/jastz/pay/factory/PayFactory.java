package me.jastz.pay.factory;

import me.jastz.pay.product.AbstractPay;
import me.jastz.pay.product.impl.AliPay;
import me.jastz.pay.product.impl.WeixinPay;

public class PayFactory {

    /**
     * 简单工厂模式也叫：静态工厂模式（工厂类直接生成对象）
     *
     * @param type
     * @return
     */
    public static AbstractPay getPayMethod(String type) {
        if ("alipay".equalsIgnoreCase(type)) {
            return new AliPay();
        } else if ("weixin".equalsIgnoreCase(type)) {
            return new WeixinPay();
        } else {
            return null;
        }
    }

}
