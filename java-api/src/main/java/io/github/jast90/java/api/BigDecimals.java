package io.github.jast90.java.api;

import java.math.BigDecimal;

/**
 * @author zhangzhiwen
 * @Description:
 * @date 2021/12/22 13:43
 */
public class BigDecimals {

    public static void main(String[] args) {
        test();
    }

    private static void test(){
        BigDecimal closingPrice = null;
        BigDecimal settlementPrice = null;
        boolean result = !(closingPrice != null && closingPrice.compareTo(BigDecimal.ZERO) == 1 ||
        settlementPrice != null && settlementPrice.compareTo(BigDecimal.ZERO) == 1);
        System.out.println(result);
    }
}
