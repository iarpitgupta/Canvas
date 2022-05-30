package main.java.exceptions;

/**
 * CanvasNotFoundException will be thrown when a command tries to
 * draw something without Canvas being initialized.
 */
public class CanvasNotFoundException extends Exception {
    public CanvasNotFoundException(String message) {
        super(message);
    }
}
