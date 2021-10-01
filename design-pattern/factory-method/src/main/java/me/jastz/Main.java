package me.jastz;

import me.jastz.service.PayService;
import me.jastz.service.PayType;

/**
 * @author zhiwen
 */
public class Main {


    public static void main(String[] args) {
        /**
         * 客户端调用时需要传递具体的支付方式
         */
        PayService.refund(10, PayType.ALIPAY);
    }
}
