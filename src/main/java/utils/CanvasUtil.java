package main.java.utils;

import main.java.Canvas;
import main.java.exceptions.InvalidCoordinateException;
import main.java.exceptions.InvalidParametersException;

import static main.java.constants.CanvasConstants.*;

/**
 * CanvasUtil is responsible for providing utility methods.
 */
public class CanvasUtil {

    public static int parseInputToInt(String integer) throws InvalidParametersException {
        try {
            return Integer.parseInt(integer);
        } catch (NumberFormatException exception) {
            throw new InvalidParametersException("Invalid Parameters");
        }
    }

    public static String[] splitCommand(String command) {
        return command.trim().split(WHITE_SPACE);
    }

    public static void validateXCoordinates(int... x_Coordinates) throws InvalidCoordinateException {
        for (int x_Coordinate : x_Coordinates) {
            if (x_Coordinate <= 0 || x_Coordinate > Canvas.getInstance().getWidth() - CANVAS_BORDER) {
                throw new InvalidCoordinateException(X_COORDINATE_OUT_OF_CANVAS);
            }
        }
    }

    public static void validateYCoordinates(int... y_Coordinates) throws InvalidCoordinateException {
        for (int y_Coordinate : y_Coordinates) {
            if (y_Coordinate <= 0 || y_Coordinate > Canvas.getInstance().getHeight() - CANVAS_BORDER) {
                throw new InvalidCoordinateException(Y_COORDINATE_OUT_OF_CANVAS);
            }
        }
    }
}
