package me.jastz.electrical.factory.impl;

import me.jastz.electrical.factory.EFactory;
import me.jastz.electrical.product.AirConditioner;
import me.jastz.electrical.product.Television;
import me.jastz.electrical.product.impl.tcl.TclAirConditioner;
import me.jastz.electrical.product.impl.tcl.TclTelevision;

/**
 * @author zhiwen
 */
public class TclEFactory implements EFactory {
    @Override
    public Television produceTelevision() {
        return new TclTelevision();
    }

    @Override
    public AirConditioner produceAirConditioner() {
        return new TclAirConditioner();
    }
}
