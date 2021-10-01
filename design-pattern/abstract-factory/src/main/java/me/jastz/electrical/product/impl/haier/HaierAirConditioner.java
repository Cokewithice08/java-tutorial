package me.jastz.electrical.product.impl.haier;

import me.jastz.electrical.product.AirConditioner;

/**
 * @author zhiwen
 */
public class HaierAirConditioner implements AirConditioner {
    @Override
    public void changeTemperature() {
        System.out.println("Haier 空调");
    }
}
