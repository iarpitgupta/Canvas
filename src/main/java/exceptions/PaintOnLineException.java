package main.java.exceptions;

/**
 * PaintOnLineException will be thrown when provided paint command coordinates
 * clashes with Line drawn.
 */
public class PaintOnLineException extends Exception {
    public PaintOnLineException(String message) {
        super(message);
    }
}
