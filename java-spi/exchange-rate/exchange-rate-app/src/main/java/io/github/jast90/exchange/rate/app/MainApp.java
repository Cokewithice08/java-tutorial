package io.github.jast90.exchange.rate.app;

import io.github.jast90.exchange.rate.ExchangeRate;
import io.github.jast90.exchange.rate.api.Quote;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by jast90 on 2021/4/6
 */
public class MainApp {

    public static void main(String[] args) {
        ExchangeRate.providers().forEach(exchangeRateProvider -> {
            System.out.println("Retreiving USD quotes from provider :"+exchangeRateProvider);
            List<Quote> quotes = exchangeRateProvider.create().getQuotes("USD", LocalDate.now());
            System.out.println(String.format("%14s%12s|%12s", "","Ask", "Bid"));
            System.out.println("----------------------------------------");
            quotes.forEach(quote -> {
                System.out.println("USD-->"+quote.getCurrency()+" : "+String.format("%12f|%12f",quote.getAsk(),quote.getBig()));
            });
        });
    }
}
