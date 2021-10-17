package io.github.jast90.decorator.impl;

import io.github.jast90.decorator.Component;

public class Window implements Component {
    @Override
    public void display() {
        System.out.println("显示窗体");
    }
}
