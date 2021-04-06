package io.github.jast90.exchange.rate.exception;

/**
 * Created by jast90 on 2021/4/6
 */
public class ProviderNotFoundException extends RuntimeException{

    public ProviderNotFoundException() {
        super();
    }

    public ProviderNotFoundException(String message){
        super(message);
    }
}
