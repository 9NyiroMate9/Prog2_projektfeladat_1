package hu.restaurant.model.ingredients;

import hu.restaurant.model.OrderItem;
import hu.restaurant.model.PizzaItem;

public class Ham implements OrderItem, PizzaItem {
    private final OrderItem base;

    public Ham(OrderItem base) {
        this.base = base;
    }

    @Override
    public String getName() {
        return base.getName() + ", Sonka";
    }

    @Override
    public int getPrice() {
        return base.getPrice() + 400;
    }
}
