package me.jastz.kfc;

import me.jastz.kfc.combo.Drink;
import me.jastz.kfc.combo.Food;
import me.jastz.kfc.combo.KfcComboBuilder;

public class Client {
    public static void main(String[] args) {
        /**
         *  该实例展示 省略抽象建造者、指挥者（具体建造者充当指挥者直接构建产品）
         */
        System.out.println(KfcComboBuilder.getInstance().buildFood(Food.HAMBURGER).buildDrink(Drink.JUICE).build());
    }
}
