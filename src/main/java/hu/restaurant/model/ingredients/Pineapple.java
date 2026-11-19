package hu.restaurant.model.ingredients;

import hu.restaurant.model.OrderItem;
import hu.restaurant.model.PizzaItem;

public class Pineapple implements OrderItem, PizzaItem {
    private final OrderItem base;

    public Pineapple(OrderItem base) {
        this.base = base;
    }

    @Override
    public String getName() {
        return base.getName() + ", Ananász";
    }

    @Override
    public int getPrice() {
        return base.getPrice() + 350;
    }
}
