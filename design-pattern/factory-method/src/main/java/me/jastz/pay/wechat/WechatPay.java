package me.jastz.pay.wechat;

import me.jastz.pay.Pay;

/**
 * 微信支付（具体产品）
 *
 * @author zhiwen
 */
public class WechatPay implements Pay {
    @Override
    public void pay() {
        System.out.println("微信支付");
    }
}
