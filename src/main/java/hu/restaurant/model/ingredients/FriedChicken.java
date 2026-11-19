package hu.restaurant.model.ingredients;

import hu.restaurant.model.BurgerItem;
import hu.restaurant.model.OrderBase;
import hu.restaurant.model.OrderItem;

public class FriedChicken implements OrderItem, BurgerItem, OrderBase {
    @Override
    public String getName() {
        return "Rántott csirkemell";
    }

    @Override
    public int getPrice() {
        return 1600;
    }
}
