package main.exceptions;

public class BadSKUException extends RuntimeException {

    public BadSKUException(String message) {
        super(message);
    }
}
