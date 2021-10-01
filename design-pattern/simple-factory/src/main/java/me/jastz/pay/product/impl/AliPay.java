package me.jastz.pay.product.impl;

import me.jastz.pay.product.AbstractPay;

public class AliPay extends AbstractPay {

    public void pay() {
        System.out.println("支付宝支付");
    }
}
