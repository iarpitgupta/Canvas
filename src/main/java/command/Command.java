package main.java.command;

import main.java.exceptions.CanvasNotFoundException;
import main.java.exceptions.InvalidCoordinateException;
import main.java.exceptions.InvalidParametersException;

public interface Command {

    void execute() throws InvalidParametersException, InvalidCoordinateException, CanvasNotFoundException;

    boolean validateParameters(String[] commandParameters) throws InvalidParametersException, CanvasNotFoundException;

}
