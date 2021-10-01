package me.jastz.pay.wechat;

import me.jastz.pay.Pay;
import me.jastz.pay.PayFactory;

/**
 * 微信支付 工厂（具体产品）
 *
 * @author zhiwen
 */
public class WechatPayFactory implements PayFactory {
    @Override
    public Pay getPay() {
        return new WechatPay();
    }
}
