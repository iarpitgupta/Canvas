package main.java.exceptions;

/**
 * InvalidParametersException will be thrown when parameters provided with any command
 * does not comply with business logic.
 */
public class InvalidParametersException extends Exception {
    public InvalidParametersException(String message) {
        super(message);
    }
}
