package main.java.exceptions;

/**
 * InvalidCommandException will be thrown when command provided is not supported
 * by the system.
 */
public class InvalidCommandException extends Exception {

    public InvalidCommandException(String message) {
        super(message);
    }
}
