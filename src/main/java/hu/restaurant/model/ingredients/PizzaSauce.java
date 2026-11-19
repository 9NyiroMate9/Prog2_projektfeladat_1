package hu.restaurant.model.ingredients;

import hu.restaurant.model.OrderBase;
import hu.restaurant.model.OrderItem;
import hu.restaurant.model.PizzaItem;

public class PizzaSauce implements OrderItem, PizzaItem, OrderBase {
    @Override
    public String getName() {
        return "Paradicsomos alap";
    }

    @Override
    public int getPrice() {
        return 1400;
    }
}
