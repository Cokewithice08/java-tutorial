package io.github.jast90.exchange.rate;

import io.github.jast90.exchange.rate.exception.ProviderNotFoundException;
import io.github.jast90.exchange.rate.spi.ExchangeRateProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ServiceLoader;

/**
 * Created by jast90 on 2021/4/6
 */
public class ExchangeRate {
    private static final String DEFAULT_PROVIDER = "io.github.jast90.exchange.rate.spi.YahooFinanceExchangeRateProvider";

    public static List<ExchangeRateProvider> providers() {
        List<ExchangeRateProvider> services = new ArrayList<>();
        ServiceLoader<ExchangeRateProvider> loader = ServiceLoader.load(ExchangeRateProvider.class);
        loader.forEach(exchangeRateProvider -> services.add(exchangeRateProvider));
        return services;
    }

    public static ExchangeRateProvider provider() {
        return provider(DEFAULT_PROVIDER);//TODO
    }

    public static ExchangeRateProvider provider(String providerName) {
        ServiceLoader<ExchangeRateProvider> loader = ServiceLoader.load(ExchangeRateProvider.class);
        Iterator<ExchangeRateProvider> iterator = loader.iterator();
        while (iterator.hasNext()) {
            ExchangeRateProvider provider = iterator.next();
            if (providerName.equals(provider.getClass().getName())) {
                return provider;
            }
        }
        throw new ProviderNotFoundException();
    }
}
