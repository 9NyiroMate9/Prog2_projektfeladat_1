package hu.restaurant.ui;

import hu.restaurant.model.Order;
import hu.restaurant.model.OrderItem;
import hu.restaurant.model.PaymentType;
import hu.restaurant.model.ingredients.*;
import hu.restaurant.storage.OrderRepository;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class ConsoleUI {
    private final Scanner scanner;
    private final OrderRepository repository;
    private final List<Order> orders;

    public ConsoleUI() {
        this.scanner = new Scanner(System.in);
        this.repository = new OrderRepository();
        this.orders = new ArrayList<>(repository.loadOrders());
    }

    public void start() {
        while (true) {
            System.out.println("\n=== ÉTTEREM ONLINE RENDELŐ ===");
            System.out.println("1. Rendelés leadása");
            System.out.println("2. Rendelések megtekintése");
            System.out.println("0. Kilépés");

            int choice = readInt("Válassz egy menüpontot: ");

            switch (choice) {
                case 1 -> handleOrderCreation();
                case 2 -> handleViewOrders();
                case 0 -> {
                    System.out.println("Viszontlátásra!");
                    return;
                }
                default -> System.out.println("Érvénytelen választás! Próbáld újra.");
            }
        }
    }

    private void handleOrderCreation() {
        while (true) {
            System.out.println("\n--- ÚJ RENDELÉS: ÉTELTÍPUS ---");
            System.out.println("1. Pizza");
            System.out.println("2. Burger");
            System.out.println("0. Vissza a főmenübe");

            int choice = readInt("Választás: ");
            switch (choice) {
                case 1 -> {
                    if (buildPizza()) return;
                }
                case 2 -> {
                    if (buildBurger()) return;
                }
                case 0 -> {
                    return;
                }
                default -> System.out.println("Érvénytelen választás!");
            }
        }
    }

    private boolean buildPizza() {
        OrderItem currentPizza;
        while (true) {
            System.out.println("\n--- PIZZA ALAP VÁLASZTÁSA ---");
            System.out.println("1. Paradicsomos alap (1400 Ft)");
            System.out.println("2. Tejfölös alap (1500 Ft)");
            System.out.println("0. Vissza");

            int choice = readInt("Választás: ");
            if (choice == 0) return false;
            if (choice == 1) {
                currentPizza = new PizzaSauce();
                break;
            } else if (choice == 2) {
                currentPizza = new YogurtBase();
                break;
            } else {
                System.out.println("Érvénytelen választás!");
            }
        }

        while (true) {
            printCurrentSelection(currentPizza);
            System.out.println("--- PIZZA FELTÉTEK ---");
            System.out.println("1. Sonka (+400 Ft)");
            System.out.println("2. Pepperoni (+450 Ft)");
            System.out.println("3. Gomba (+300 Ft)");
            System.out.println("4. Ananász (+350 Ft)");
            System.out.println("5. Chili paprika (+250 Ft)");
            System.out.println("6. Hagyma (+200 Ft)");
            System.out.println("7. Paradicsom (+250 Ft)");
            System.out.println("8. Sajt (+350 Ft)");
            System.out.println("9. Bacon (+450 Ft)");
            System.out.println("10. Rendelés véglegesítése");
            System.out.println("0. Vissza (rendelés elvetése)");

            int choice = readInt("Választás: ");
            switch (choice) {
                case 1 -> currentPizza = new Ham(currentPizza);
                case 2 -> currentPizza = new Pepperoni(currentPizza);
                case 3 -> currentPizza = new Mushroom(currentPizza);
                case 4 -> currentPizza = new Pineapple(currentPizza);
                case 5 -> currentPizza = new ChiliPepper(currentPizza);
                case 6 -> currentPizza = new Onion(currentPizza);
                case 7 -> currentPizza = new Tomato(currentPizza);
                case 8 -> currentPizza = new Cheese(currentPizza);
                case 9 -> currentPizza = new Bacon(currentPizza);
                case 10 -> {
                    return finalizeOrder(currentPizza);
                }
                case 0 -> {
                    return false;
                }
                default -> System.out.println("Érvénytelen választás!");
            }
        }
    }

    private boolean buildBurger() {
        OrderItem currentBurger;
        while (true) {
            System.out.println("\n--- BURGER HÚS VÁLASZTÁSA ---");
            System.out.println("1. Marhahúspogácsa (1800 Ft)");
            System.out.println("2. Rántott csirkemell (1600 Ft)");
            System.out.println("0. Vissza");

            int choice = readInt("Választás: ");
            if (choice == 0) return false;
            if (choice == 1) {
                currentBurger = new BeefPatty();
                break;
            } else if (choice == 2) {
                currentBurger = new FriedChicken();
                break;
            } else {
                System.out.println("Érvénytelen választás!");
            }
        }

        while (true) {
            printCurrentSelection(currentBurger);
            System.out.println("--- BURGER FELTÉTEK ---");
            System.out.println("1. Hagyma (+200 Ft)");
            System.out.println("2. Paradicsom (+250 Ft)");
            System.out.println("3. Sajt (+350 Ft)");
            System.out.println("4. Bacon (+450 Ft)");
            System.out.println("5. Savanyú uborka (+200 Ft)");
            System.out.println("6. Saláta (+200 Ft)");
            System.out.println("7. Ketchup (+150 Ft)");
            System.out.println("8. Majonéz (+150 Ft)");
            System.out.println("9. Rendelés véglegesítése");
            System.out.println("0. Vissza (rendelés elvetése)");

            int choice = readInt("Választás: ");
            switch (choice) {
                case 1 -> currentBurger = new Onion(currentBurger);
                case 2 -> currentBurger = new Tomato(currentBurger);
                case 3 -> currentBurger = new Cheese(currentBurger);
                case 4 -> currentBurger = new Bacon(currentBurger);
                case 5 -> currentBurger = new Pickle(currentBurger);
                case 6 -> currentBurger = new Lettuce(currentBurger);
                case 7 -> currentBurger = new Ketchup(currentBurger);
                case 8 -> currentBurger = new Mayonnaise(currentBurger);
                case 9 -> {
                    return finalizeOrder(currentBurger);
                }
                case 0 -> {
                    return false;
                }
                default -> System.out.println("Érvénytelen választás!");
            }
        }
    }

    private boolean finalizeOrder(OrderItem item) {
        System.out.println("\n--- RENDELÉS VÉGLEGESÍTÉSE ---");
        printCurrentSelection(item);

        System.out.print("Add meg a szállítási címet (vagy 0 a visszalépéshez): ");
        String address = scanner.nextLine().trim();
        if (address.equals("0")) {
            return false;
        }
        while (address.isEmpty()) {
            System.out.print("A cím nem lehet üres! Add meg újra: ");
            address = scanner.nextLine().trim();
            if (address.equals("0")) return false;
        }

        PaymentType paymentType;
        while (true) {
            System.out.println("\nVálassz fizetési módot:");
            System.out.println("1. Előrefizetés");
            System.out.println("2. Fizetés átvételkor");
            System.out.println("0. Vissza");

            int choice = readInt("Választás: ");
            if (choice == 0) return false;
            if (choice == 1) {
                paymentType = PaymentType.PREPAYMENT;
                break;
            } else if (choice == 2) {
                paymentType = PaymentType.CASH_ON_DELIVERY;
                break;
            } else {
                System.out.println("Érvénytelen választás!");
            }
        }

        Order order = new Order(item, LocalDateTime.now(), address, paymentType);
        orders.add(order);
        repository.saveOrder(order);

        System.out.println("\n>>> Rendelés sikeresen leadva! <<<");
        System.out.println(order);
        return true;
    }

    private void handleViewOrders() {
        boolean sortByPrice = false;

        while (true) {
            System.out.println("\n--- LEADOTT RENDELÉSEK ---");
            if (orders.isEmpty()) {
                System.out.println("Még nincs leadott rendelés.");
            } else {
                List<Order> sorted = new ArrayList<>(orders);
                if (sortByPrice) {
                    sorted.sort(Comparator.comparingInt(Order::getTotalPrice));
                    System.out.println("(Rendezés: Ár szerint növekvő)");
                } else {
                    sorted.sort(Comparator.comparing(Order::getOrderDate));
                    System.out.println("(Rendezés: Dátum szerint)");
                }

                for (int i = 0; i < sorted.size(); i++) {
                    System.out.println((i + 1) + ". " + sorted.get(i));
                }
            }

            System.out.println("\n1. Rendezés dátum szerint (alapértelmezett)");
            System.out.println("2. Rendezés ár szerint");
            System.out.println("0. Vissza a főmenübe");

            int choice = readInt("Választás: ");
            switch (choice) {
                case 1 -> sortByPrice = false;
                case 2 -> sortByPrice = true;
                case 0 -> {
                    return;
                }
                default -> System.out.println("Érvénytelen választás!");
            }
        }
    }

    private void printCurrentSelection(OrderItem item) {
        System.out.println("\nAktuális összeállítás: " + item.getName());
        System.out.println("Jelenlegi végösszeg: " + item.getPrice() + " Ft\n");
    }

    private int readInt(String prompt) {
        while (true) {
            System.out.print(prompt);
            String input = scanner.nextLine().trim();
            try {
                return Integer.parseInt(input);
            } catch (NumberFormatException e) {
                System.out.println("Kérlek egy egész számot adj meg!");
            }
        }
    }
}
