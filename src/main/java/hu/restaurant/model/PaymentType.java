package hu.restaurant.model;

public enum PaymentType {
    PREPAYMENT("Előrefizetés"),
    CASH_ON_DELIVERY("Fizetés átvételkor");

    private final String displayName;

    PaymentType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }
}
