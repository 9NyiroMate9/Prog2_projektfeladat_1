package hu.restaurant.model.ingredients;

import hu.restaurant.model.BurgerItem;
import hu.restaurant.model.OrderItem;

public class Ketchup implements OrderItem, BurgerItem {
    private final OrderItem base;

    public Ketchup(OrderItem base) {
        this.base = base;
    }

    @Override
    public String getName() {
        return base.getName() + ", Ketchup";
    }

    @Override
    public int getPrice() {
        return base.getPrice() + 150;
    }
}
