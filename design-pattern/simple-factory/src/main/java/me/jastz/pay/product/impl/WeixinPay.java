package me.jastz.pay.product.impl;

import me.jastz.pay.product.AbstractPay;

public class WeixinPay extends AbstractPay {
    public void pay() {
        System.out.println("微信支付");
    }
}
