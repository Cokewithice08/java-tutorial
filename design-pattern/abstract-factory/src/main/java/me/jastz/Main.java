package me.jastz;

import me.jastz.electrical.factory.EFactory;
import me.jastz.electrical.factory.impl.HaierEFactory;
import me.jastz.electrical.factory.impl.TclEFactory;

/**
 * @author zhiwen
 */
public class Main {
    public static void main(String[] args) {
        EFactory eFactory = new HaierEFactory();
        eFactory.produceTelevision().play();
        eFactory.produceAirConditioner().changeTemperature();

        eFactory = new TclEFactory();
        eFactory.produceTelevision().play();
        eFactory.produceAirConditioner().changeTemperature();
    }
}
