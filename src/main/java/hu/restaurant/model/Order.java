package hu.restaurant.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Order {
    private final OrderItem item;
    private final LocalDateTime orderDate;
    private final String deliveryAddress;
    private final PaymentType paymentType;

    public Order(OrderItem item, LocalDateTime orderDate, String deliveryAddress, PaymentType paymentType) {
        this.item = item;
        this.orderDate = orderDate;
        this.deliveryAddress = deliveryAddress;
        this.paymentType = paymentType;
    }

    public OrderItem getItem() {
        return item;
    }

    public LocalDateTime getOrderDate() {
        return orderDate;
    }

    public String getDeliveryAddress() {
        return deliveryAddress;
    }

    public PaymentType getPaymentType() {
        return paymentType;
    }

    public int getTotalPrice() {
        return item.getPrice();
    }

    @Override
    public String toString() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        return String.format("[%s] %s | Ár: %d Ft | Cím: %s | Fizetés: %s",
                orderDate.format(formatter),
                item.getName(),
                getTotalPrice(),
                deliveryAddress,
                paymentType.getDisplayName());
    }
}
