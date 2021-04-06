package io.github.jast90.exchange.rate.spi;

import io.github.jast90.exchange.rate.api.QuoteManager;

/**
 * Created by jast90 on 2021/4/6
 */
public interface ExchangeRateProvider {
    QuoteManager create();
}
