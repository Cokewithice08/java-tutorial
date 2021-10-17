package io.github.jast90.decorator.decorators;

import io.github.jast90.decorator.Component;

public class ScrollBarDecorator extends ComponentDecorator{
    public ScrollBarDecorator(Component delegate) {
        super(delegate);
    }

    @Override
    public void display() {
        this.setScrollBar();
        super.display();
    }

    public void setScrollBar(){
        System.out.println("为构件添加滚动条。");
    }
}
