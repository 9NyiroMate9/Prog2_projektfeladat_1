package hu.restaurant.model.ingredients;

import hu.restaurant.model.BurgerItem;
import hu.restaurant.model.OrderItem;
import hu.restaurant.model.PizzaItem;

public class Onion implements OrderItem, PizzaItem, BurgerItem {
    private final OrderItem base;

    public Onion(OrderItem base) {
        this.base = base;
    }

    @Override
    public String getName() {
        return base.getName() + ", Hagyma";
    }

    @Override
    public int getPrice() {
        return base.getPrice() + 200;
    }
}
