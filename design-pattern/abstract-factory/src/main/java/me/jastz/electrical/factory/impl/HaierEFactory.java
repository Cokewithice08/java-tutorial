package me.jastz.electrical.factory.impl;

import me.jastz.electrical.factory.EFactory;
import me.jastz.electrical.product.AirConditioner;
import me.jastz.electrical.product.Television;
import me.jastz.electrical.product.impl.haier.HaierAirConditioner;
import me.jastz.electrical.product.impl.haier.HaierTelevision;

/**
 * @author zhiwen
 */
public class HaierEFactory implements EFactory {
    @Override
    public Television produceTelevision() {
        return new HaierTelevision();
    }

    @Override
    public AirConditioner produceAirConditioner() {
        return new HaierAirConditioner();
    }
}
