package io.github.jast90.exchange.rate.impl;

import io.github.jast90.exchange.rate.api.QuoteManager;
import io.github.jast90.exchange.rate.spi.ExchangeRateProvider;

/**
 * Created by jast90 on 2021/4/6
 */
public class YahooFinanceExchangeRateProvider implements ExchangeRateProvider {
    @Override
    public QuoteManager create() {
        return new YahooQuoteManagerImpl();
    }
}
