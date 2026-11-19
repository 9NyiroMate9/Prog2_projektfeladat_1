package hu.restaurant.model.ingredients;

import hu.restaurant.model.BurgerItem;
import hu.restaurant.model.OrderItem;

public class Mayonnaise implements OrderItem, BurgerItem {
    private final OrderItem base;

    public Mayonnaise(OrderItem base) {
        this.base = base;
    }

    @Override
    public String getName() {
        return base.getName() + ", Majonéz";
    }

    @Override
    public int getPrice() {
        return base.getPrice() + 150;
    }
}
