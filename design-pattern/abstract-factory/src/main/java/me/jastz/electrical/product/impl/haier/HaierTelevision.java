package me.jastz.electrical.product.impl.haier;

import me.jastz.electrical.product.Television;

/**
 * @author zhiwen
 */
public class HaierTelevision implements Television {
    @Override
    public void play() {
        System.out.println("Haier 电视");
    }
}
