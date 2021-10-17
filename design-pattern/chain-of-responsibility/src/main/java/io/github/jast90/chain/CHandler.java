package io.github.jast90.chain;

public class CHandler extends Handler{

    @Override
    public void handleRequest(String request) {
        if("C".equals(request)){
            System.out.println("CHandler handle");
        }else{
            next.handleRequest(request);
        }
    }
}
