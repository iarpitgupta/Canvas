package main.java.exceptions;

/**
 * ColourDoesNotExistException will be thrown when provided colour is restricted
 * or does not exist.
 */
public class ColourDoesNotExistException extends Exception {
    public ColourDoesNotExistException(String message) {
        super(message);
    }
}
