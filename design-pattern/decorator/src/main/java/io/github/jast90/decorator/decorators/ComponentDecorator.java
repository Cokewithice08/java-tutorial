package io.github.jast90.decorator.decorators;

import io.github.jast90.decorator.Component;

public class ComponentDecorator implements Component {
    private Component delegate;

    public ComponentDecorator(Component delegate) {
        this.delegate = delegate;
    }

    @Override
    public void display() {
        delegate.display();
    }



}
