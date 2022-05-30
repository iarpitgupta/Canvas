package main.java.exceptions;

/**
 * CanvasDimensionException will be thrown when dimensions of canvas provided
 * are not according to business logic.
 */
public class CanvasDimensionException extends Exception {
    public CanvasDimensionException(String message) {
        super(message);
    }
}
