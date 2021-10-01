package me.jastz.electrical.product.impl.tcl;

import me.jastz.electrical.product.Television;

/**
 * @author zhiwen
 */
public class TclTelevision implements Television {
    @Override
    public void play() {
        System.out.println("Tcl 电视");
    }
}
