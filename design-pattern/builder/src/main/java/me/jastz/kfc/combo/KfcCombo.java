package me.jastz.kfc.combo;

public class KfcCombo {
    private Food food;
    private Drink drink;

    public Food getFood() {
        return food;
    }

    public void setFood(Food food) {
        this.food = food;
    }

    public Drink getDrink() {
        return drink;
    }

    public void setDrink(Drink drink) {
        this.drink = drink;
    }

    @Override
    public String toString() {
        return "KfcCombo{" +
                "food=" + food +
                ", drink=" + drink +
                '}';
    }
}
