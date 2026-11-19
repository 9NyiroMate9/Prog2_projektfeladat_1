package hu.restaurant.model.ingredients;

import hu.restaurant.model.BurgerItem;
import hu.restaurant.model.OrderItem;
import hu.restaurant.model.PizzaItem;

public class Bacon implements OrderItem, PizzaItem, BurgerItem {
    private final OrderItem base;

    public Bacon(OrderItem base) {
        this.base = base;
    }

    @Override
    public String getName() {
        return base.getName() + ", Bacon";
    }

    @Override
    public int getPrice() {
        return base.getPrice() + 450;
    }
}
