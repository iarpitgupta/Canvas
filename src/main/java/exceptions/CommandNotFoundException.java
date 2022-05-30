package main.java.exceptions;

/**
 * CommandNotFoundException will be thrown when blank command is provided.
 */
public class CommandNotFoundException extends Exception {
    public CommandNotFoundException(String message){
        super(message);
    }
}
