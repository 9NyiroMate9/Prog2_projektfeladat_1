package hu.restaurant.storage;

import hu.restaurant.model.Order;
import hu.restaurant.model.OrderItem;
import hu.restaurant.model.PaymentType;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class OrderRepository {
    private static final String FILE_NAME = "orders.txt";

    public void saveOrder(Order order) {
        try (BufferedWriter writer = new BufferedWriter(
                new OutputStreamWriter(new FileOutputStream(FILE_NAME, true), StandardCharsets.UTF_8))) {
            String line = String.join(";",
                    order.getOrderDate().toString(),
                    order.getItem().getName().replace(";", ","),
                    String.valueOf(order.getTotalPrice()),
                    order.getDeliveryAddress().replace(";", ","),
                    order.getPaymentType().name()
            );
            writer.write(line);
            writer.newLine();
        } catch (IOException e) {
            System.out.println("Hiba a rendelés mentésekor: " + e.getMessage());
        }
    }

    public List<Order> loadOrders() {
        List<Order> orders = new ArrayList<>();
        Path path = Path.of(FILE_NAME);

        if (!Files.exists(path)) {
            return orders;
        }

        try (BufferedReader reader = Files.newBufferedReader(path, StandardCharsets.UTF_8)) {
            String line;
            while ((line = reader.readLine()) != null) {
                if (line.isBlank()) continue;
                String[] parts = line.split(";");
                if (parts.length == 5) {
                    LocalDateTime date = LocalDateTime.parse(parts[0]);
                    String itemName = parts[1];
                    int price = Integer.parseInt(parts[2]);
                    String address = parts[3];
                    PaymentType paymentType = PaymentType.valueOf(parts[4]);

                    OrderItem restoredItem = new OrderItem() {
                        @Override
                        public String getName() {
                            return itemName;
                        }

                        @Override
                        public int getPrice() {
                            return price;
                        }
                    };

                    orders.add(new Order(restoredItem, date, address, paymentType));
                }
            }
        } catch (IOException | RuntimeException e) {
            System.out.println("Hiba a rendelések beolvasásakor: " + e.getMessage());
        }

        return orders;
    }
}
