package hu.restaurant.model.ingredients;

import hu.restaurant.model.BurgerItem;
import hu.restaurant.model.OrderBase;
import hu.restaurant.model.OrderItem;

public class BeefPatty implements OrderItem, BurgerItem, OrderBase {
    @Override
    public String getName() {
        return "Marhahúspogácsa";
    }

    @Override
    public int getPrice() {
        return 1800;
    }
}
