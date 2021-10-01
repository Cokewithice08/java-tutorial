package me.jastz.electrical.product.impl.tcl;

import me.jastz.electrical.product.AirConditioner;

/**
 * @author zhiwen
 */
public class TclAirConditioner implements AirConditioner {
    @Override
    public void changeTemperature() {
        System.out.println("Tcl 空调");
    }
}
