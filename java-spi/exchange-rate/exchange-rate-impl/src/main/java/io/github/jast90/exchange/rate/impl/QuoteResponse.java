package io.github.jast90.exchange.rate.impl;

import io.github.jast90.exchange.rate.api.Quote;

import java.util.List;

/**
 * Created by jast90 on 2021/4/6
 */
public class QuoteResponse {
    private List<Quote> result;
    private String error;

    public List<Quote> getResult() {
        return result;
    }

    public void setResult(List<Quote> result) {
        this.result = result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}
