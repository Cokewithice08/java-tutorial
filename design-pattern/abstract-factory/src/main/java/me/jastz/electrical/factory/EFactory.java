package me.jastz.electrical.factory;

import me.jastz.electrical.product.AirConditioner;
import me.jastz.electrical.product.Television;

/**
 * @author zhiwen
 */
public interface EFactory {
    Television produceTelevision();

    AirConditioner produceAirConditioner();
}
