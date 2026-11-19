package hu.restaurant.model.ingredients;

import hu.restaurant.model.BurgerItem;
import hu.restaurant.model.OrderItem;

public class Lettuce implements OrderItem, BurgerItem {
    private final OrderItem base;

    public Lettuce(OrderItem base) {
        this.base = base;
    }

    @Override
    public String getName() {
        return base.getName() + ", Saláta";
    }

    @Override
    public int getPrice() {
        return base.getPrice() + 200;
    }
}
