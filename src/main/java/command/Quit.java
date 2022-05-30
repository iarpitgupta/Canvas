package main.java.command;

import main.java.exceptions.InvalidParametersException;

import static main.java.constants.CanvasConstants.*;

/**
 * Quit class is responsible for validating input
 * and exit the application safely.
 */
public class Quit implements Command {

    String[] commandParameters;

    Quit(String[] commandParameters) {
        this.commandParameters = commandParameters;
    }

    @Override
    public void execute() throws InvalidParametersException {
        if (validateParameters(commandParameters)) {
            System.out.println(EXIT_MESSAGE);
            System.exit(EXIT_STATUS);
        }
    }

    @Override
    public boolean validateParameters(String[] commandParameters) throws InvalidParametersException {
        if (commandParameters.length != 1) {
            throw new InvalidParametersException(INVALID_PARAMETERS);
        }
        return true;
    }
}
