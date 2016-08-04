package main.exceptions;

public class ProductNotInDBException extends RuntimeException {

    public ProductNotInDBException(String message) {
        super(message);
    }
}
