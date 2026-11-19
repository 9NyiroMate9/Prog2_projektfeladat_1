package hu.restaurant.model.ingredients;

import hu.restaurant.model.OrderItem;
import hu.restaurant.model.PizzaItem;

public class Pepperoni implements OrderItem, PizzaItem {
    private final OrderItem base;

    public Pepperoni(OrderItem base) {
        this.base = base;
    }

    @Override
    public String getName() {
        return base.getName() + ", Pepperoni";
    }

    @Override
    public int getPrice() {
        return base.getPrice() + 450;
    }
}
