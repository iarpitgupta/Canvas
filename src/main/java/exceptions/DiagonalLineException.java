package main.java.exceptions;

/**
 * DiagonalLineException will be thrown when coordinates for drawing line
 * diagonally are provided.
 */
public class DiagonalLineException extends Exception {
    public DiagonalLineException(String message) {
        super(message);
    }
}
