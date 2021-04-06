package io.github.jast90.exchange.rate.impl;

import io.github.jast90.exchange.rate.api.Quote;
import io.github.jast90.exchange.rate.api.QuoteManager;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import javax.json.bind.JsonbBuilder;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.util.Currency;
import java.util.List;

/**
 * Created by jast90 on 2021/4/6
 */
public class YahooQuoteManagerImpl implements QuoteManager {
    static final String URL_PROVIDER = "https://query1.finance.yahoo.com/v7/finance/quote";
    OkHttpClient okHttpClient = new OkHttpClient();
    @Override
    public List<Quote> getQuotes(String baseCurrency, LocalDate date) {
        StringBuilder sb = new StringBuilder();
        Currency.getAvailableCurrencies().forEach(currency -> {
            if (!currency.equals(currency.getCurrencyCode())) {
                sb.append(baseCurrency).append(currency.getCurrencyCode()).append("=X").append(",");
            }
        });
        String value = "";
        try {
            value = URLEncoder.encode(sb.toString().substring(0,sb.toString().length()-1),"UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        String queryString = String.format("%s=%s","symbols",value);
        String response = doGetRequest(queryString);
        System.out.println(response);
        return map(response);
    }

    private List<Quote> map(String response) {
        QuoteResponseWrapper qrw = JsonbBuilder.create().fromJson(response,QuoteResponseWrapper.class);
        return qrw.getResponse().getResult();
    }

    private String doGetRequest(String queryString) {
        String fullUrl = URL_PROVIDER+"?"+queryString;
        System.out.println(fullUrl);
        Request request = new Request.Builder().url(fullUrl).build();
        Response response = null;
        try {
            response = okHttpClient.newCall(request).execute();
            return response.body().string();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
