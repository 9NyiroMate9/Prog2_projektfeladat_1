package hu.restaurant.model.ingredients;

import hu.restaurant.model.OrderItem;
import hu.restaurant.model.PizzaItem;

public class ChiliPepper implements OrderItem, PizzaItem {
    private final OrderItem base;

    public ChiliPepper(OrderItem base) {
        this.base = base;
    }

    @Override
    public String getName() {
        return base.getName() + ", Chili paprika";
    }

    @Override
    public int getPrice() {
        return base.getPrice() + 250;
    }
}
