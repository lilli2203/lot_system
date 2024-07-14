package com.parking.Modules;

public enum PaymentMode {
    CASH("Cash Payment"),
    CREDIT_CARD("Credit Card Payment"),
    DEBIT_CARD("Debit Card Payment"),
    UPI("UPI Payment"),
    NET_BANKING("Net Banking Payment"),
    WALLET("Wallet Payment"),
    OTHERS("Other Payment Modes");

    private final String description;

    PaymentMode(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static PaymentMode fromString(String mode) {
        for (PaymentMode m : PaymentMode.values()) {
            if (m.name().equalsIgnoreCase(mode)) {
                return m;
            }
        }
        throw new IllegalArgumentException("Unknown payment mode: " + mode);
    }

    @Override
    public String toString() {
        return this.name() + ": " + this.getDescription();
    }

    public boolean isDigital() {
        switch (this) {
            case CREDIT_CARD:
            case DEBIT_CARD:
            case UPI:
            case NET_BANKING:
            case WALLET:
                return true;
            case CASH:
            case OTHERS:
            default:
                return false;
        }
    }
}
