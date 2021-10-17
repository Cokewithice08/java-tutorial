package io.github.jast90.chain;

public class Client {

    public static void main(String[] args) {
        Handler a,b,c;
        a = new AHandler();
        b = new BHandler();
        c = new CHandler();
        a.setNext(b);
        b.setNext(c);

        a.handleRequest("A");
        a.handleRequest("B");
        a.handleRequest("C");
    }
}
