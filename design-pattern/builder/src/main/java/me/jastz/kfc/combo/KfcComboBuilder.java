package me.jastz.kfc.combo;

public class KfcComboBuilder {

    private static KfcComboBuilder instance = new KfcComboBuilder();

    private KfcComboBuilder() {

    }

    public static KfcComboBuilder getInstance() {
        return instance;
    }

    private KfcCombo kfcCombo = new KfcCombo();

    public KfcComboBuilder buildFood(Food food) {
        kfcCombo.setFood(food);
        return this;
    }

    public KfcComboBuilder buildDrink(Drink drink) {
        kfcCombo.setDrink(drink);
        return this;
    }

    public KfcCombo build() {
        return kfcCombo;
    }
}
