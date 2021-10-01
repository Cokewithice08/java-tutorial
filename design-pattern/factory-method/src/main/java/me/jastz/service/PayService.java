package me.jastz.service;

import me.jastz.pay.PayFactory;
import me.jastz.pay.alipay.AliPayFactory;

/**
 * @author zhiwen
 */
public class PayService {

    public static void refund(int amount, PayType payType) {
        PayFactory factory = null;
        if (PayType.ALIPAY == payType) {
            factory = new AliPayFactory();
        } else if (PayType.WECHAT == payType) {
            factory = new AliPayFactory();
        }

        if (factory == null) {
            return;
        }

        factory.getPay().pay();
        System.out.println("支付金额：" + amount);

    }
}
