package com.parking.Exceptions;

public class InvalidException extends Exception {
    private int errorCode;

    public InvalidException(String message) {
        super(message);
    }
    public InvalidException(String message, Throwable cause) {
        super(message, cause);
    }

    public InvalidException(String message, int errorCode) {
        super(message);
        this.errorCode = errorCode;
    }

    public InvalidException(String message, Throwable cause, int errorCode) {
        super(message, cause);
        this.errorCode = errorCode;
    }

    public int getErrorCode() {
        return errorCode;
    }
    public void setErrorCode(int errorCode) {
        this.errorCode = errorCode;
    }
    @Override
    public String toString() {
        return "InvalidException{" +
                "errorCode=" + errorCode +
                ", message=" + getMessage() +
                '}';
    }
}
