package hu.restaurant.model.ingredients;

import hu.restaurant.model.BurgerItem;
import hu.restaurant.model.OrderItem;

public class Pickle implements OrderItem, BurgerItem {
    private final OrderItem base;

    public Pickle(OrderItem base) {
        this.base = base;
    }

    @Override
    public String getName() {
        return base.getName() + ", Savanyú uborka";
    }

    @Override
    public int getPrice() {
        return base.getPrice() + 200;
    }
}
