package main.java.utils;

import main.java.Canvas;
import main.java.exceptions.InvalidCoordinateException;
import main.java.exceptions.InvalidParametersException;

import static main.java.constants.CanvasConstants.BLANK;

public class CanvasUtil {

    public static int parseInputToInt(String integer) throws InvalidParametersException {
        try {
            return Integer.parseInt(integer);
        } catch (NumberFormatException exception) {
            throw new InvalidParametersException("Invalid Parameters");
        }
    }

    public static String[] splitCommand(String command) {
        return command.trim().split(BLANK);
    }

    public static void validateXAxisPoints(int... x_Coordinates) throws InvalidCoordinateException {
        for (int x_Coordinate : x_Coordinates) {
            if (x_Coordinate <= 0 || x_Coordinate > Canvas.getInstance().getWidth() - 2) {
                throw new InvalidCoordinateException("X Coordinate is out of canvas.");
            }
        }
    }

    public static void validateYAxisPoints(int... y_Coordinates) throws InvalidCoordinateException {
        for (int y_Coordinate : y_Coordinates) {
            if (y_Coordinate <= 0 || y_Coordinate > Canvas.getInstance().getHeight() - 2) {
                throw new InvalidCoordinateException("Y Coordinate is out of canvas.");
            }
        }
    }
}
