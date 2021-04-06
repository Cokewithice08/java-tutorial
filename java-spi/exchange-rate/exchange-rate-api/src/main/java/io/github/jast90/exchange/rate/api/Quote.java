package io.github.jast90.exchange.rate.api;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * Created by jast90 on 2021/4/6
 */
public class Quote {

    private String currency;
    private BigDecimal ask;
    private BigDecimal big;
    private LocalDate date;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getAsk() {
        return ask;
    }

    public void setAsk(BigDecimal ask) {
        this.ask = ask;
    }

    public BigDecimal getBig() {
        return big;
    }

    public void setBig(BigDecimal big) {
        this.big = big;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }
}
