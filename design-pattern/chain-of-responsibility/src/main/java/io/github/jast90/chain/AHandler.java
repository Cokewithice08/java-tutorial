package io.github.jast90.chain;

public class AHandler extends Handler{

    @Override
    public void handleRequest(String request) {
        if("A".equals(request)){
            System.out.println("AHandler handle");
        }else{
            next.handleRequest(request);
        }
    }
}
