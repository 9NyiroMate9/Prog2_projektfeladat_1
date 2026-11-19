package hu.restaurant.model.ingredients;

import hu.restaurant.model.OrderItem;
import hu.restaurant.model.PizzaItem;

public class Mushroom implements OrderItem, PizzaItem {
    private final OrderItem base;

    public Mushroom(OrderItem base) {
        this.base = base;
    }

    @Override
    public String getName() {
        return base.getName() + ", Gomba";
    }

    @Override
    public int getPrice() {
        return base.getPrice() + 300;
    }
}
