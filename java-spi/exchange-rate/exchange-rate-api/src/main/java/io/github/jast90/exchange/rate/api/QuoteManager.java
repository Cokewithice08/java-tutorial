package io.github.jast90.exchange.rate.api;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by jast90 on 2021/4/6
 */
public interface QuoteManager {
    List<Quote> getQuotes(String baseCurrency, LocalDate date);
}
