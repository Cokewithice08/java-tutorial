package me.jastz.pay.alipay;

import me.jastz.pay.Pay;

/**
 * 支付宝支付（具体产品）
 *
 * @author zhiwen
 */
public class AliPay implements Pay {
    @Override
    public void pay() {
        System.out.println("支付宝支付");
    }
}
