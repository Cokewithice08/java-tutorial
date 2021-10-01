package me.jastz.service;

import me.jastz.pay.factory.PayFactory;
import me.jastz.pay.product.AbstractPay;

public class PayService {

    public static void pay(String payMethod) {
        AbstractPay pay = PayFactory.getPayMethod(payMethod);
        if (pay != null) pay.pay();
    }
}
