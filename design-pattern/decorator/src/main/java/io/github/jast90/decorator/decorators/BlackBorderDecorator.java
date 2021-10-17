package io.github.jast90.decorator.decorators;

import io.github.jast90.decorator.Component;

public class BlackBorderDecorator extends ComponentDecorator{
    public BlackBorderDecorator(Component delegate) {
        super(delegate);
    }

    @Override
    public void display() {
        this.setBlackBorder();
        super.display();
    }

    public void setBlackBorder(){
        System.out.println("为构件增加黑色边框");
    }
}
