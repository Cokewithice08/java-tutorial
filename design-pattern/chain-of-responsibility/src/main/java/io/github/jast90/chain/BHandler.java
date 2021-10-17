package io.github.jast90.chain;

public class BHandler extends Handler{

    @Override
    public void handleRequest(String request) {
        if("B".equals(request)){
            System.out.println("BHandler handle");
        }else{
            next.handleRequest(request);
        }

    }
}
