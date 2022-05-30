package main.java.exceptions;

/**
 * InvalidCoordinateException will be thrown when coordinated provided for any
 * drawing is invalid according to business logic.
 */
public class InvalidCoordinateException extends Exception {
    public InvalidCoordinateException(String message) {
        super(message);
    }
}
