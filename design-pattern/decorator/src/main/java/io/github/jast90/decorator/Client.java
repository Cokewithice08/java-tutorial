package io.github.jast90.decorator;

import io.github.jast90.decorator.decorators.BlackBorderDecorator;
import io.github.jast90.decorator.decorators.ScrollBarDecorator;
import io.github.jast90.decorator.impl.Window;

public class Client {

    public static void main(String[] args) {
        Component component = new Window();
        ScrollBarDecorator scrollBarDecorator = new ScrollBarDecorator(component);
        BlackBorderDecorator blackBorderDecorator = new BlackBorderDecorator(scrollBarDecorator);
        blackBorderDecorator.display();
    }
}
