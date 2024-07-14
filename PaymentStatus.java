package com.parking.Modules;

public enum PaymentStatus {
    SUCCESS("Payment was successful"),
    FAILED("Payment failed"),
    PENDING("Payment is pending"),
    CANCELLED("Payment was cancelled"),
    REFUNDED("Payment was refunded");

    private final String description;

    PaymentStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static PaymentStatus fromString(String status) {
        for (PaymentStatus s : PaymentStatus.values()) {
            if (s.name().equalsIgnoreCase(status)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Unknown payment status: " + status);
    }

    @Override
    public String toString() {
        return this.name() + ": " + this.getDescription();
    }

    public boolean isFinal() {
        switch (this) {
            case SUCCESS:
            case FAILED:
            case CANCELLED:
            case REFUNDED:
                return true;
            case PENDING:
            default:
                return false;
        }
    }

    public static PaymentStatus getStatusBasedOnCode(int code) {
        switch (code) {
            case 1:
                return SUCCESS;
            case 2:
                return FAILED;
            case 3:
                return PENDING;
            case 4:
                return CANCELLED;
            case 5:
                return REFUNDED;
            default:
                throw new IllegalArgumentException("Unknown payment status code: " + code);
        }
    }
}
