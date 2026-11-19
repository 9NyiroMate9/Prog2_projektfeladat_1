package hu.restaurant.model.ingredients;

import hu.restaurant.model.BurgerItem;
import hu.restaurant.model.OrderItem;
import hu.restaurant.model.PizzaItem;

public class Tomato implements OrderItem, PizzaItem, BurgerItem {
    private final OrderItem base;

    public Tomato(OrderItem base) {
        this.base = base;
    }

    @Override
    public String getName() {
        return base.getName() + ", Paradicsom";
    }

    @Override
    public int getPrice() {
        return base.getPrice() + 250;
    }
}
