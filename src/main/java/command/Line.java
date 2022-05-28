package main.java.command;

import main.java.Canvas;
import main.java.exceptions.CanvasNotFoundException;
import main.java.exceptions.InvalidCoordinateException;
import main.java.exceptions.InvalidParametersException;

import static main.java.constants.CanvasConstants.CANVAS_NOT_INITIALIZED;
import static main.java.constants.CanvasConstants.INVALID_PARAMETERS;
import static main.java.utils.CanvasUtil.*;

public class Line implements Command {

    Canvas canvas;
    String[] commandParameters;

    Line(Canvas canvas, String[] commandParameters) {
        this.canvas = canvas;
        this.commandParameters = commandParameters;
    }

    @Override
    public void execute() throws InvalidParametersException, InvalidCoordinateException, CanvasNotFoundException {
        if (validateParameters(commandParameters)) {
            int x1 = parseInputToInt(commandParameters[1]);
            int y1 = parseInputToInt(commandParameters[2]);
            int x2 = parseInputToInt(commandParameters[3]);
            int y2 = parseInputToInt(commandParameters[4]);
            validateXAxisPoints(x1, x2);
            validateYAxisPoints(y1, y2);
            canvas.drawLine(x1, y1, x2, y2);
        }
    }

    @Override
    public boolean validateParameters(String[] commandParameters) throws CanvasNotFoundException, InvalidParametersException {
        if (canvas.getCanvasPixels() == null) {
            throw new CanvasNotFoundException(CANVAS_NOT_INITIALIZED);
        }
        if (commandParameters.length != 5) {
            throw new InvalidParametersException(INVALID_PARAMETERS);
        }
        return true;
    }

   /* private void validateXAxisPoints(int... x_Coordinates) throws InvalidCoordinateException {
        for (int x_Coordinate : x_Coordinates) {
            if (x_Coordinate <= 0 || x_Coordinate > canvas.getWidth() - 2) {
                throw new InvalidCoordinateException("X Coordinate is out of canvas.");
            }
        }
    }

    private void validateYAxisPoints(int... y_Coordinates) throws InvalidCoordinateException {
        for (int y_Coordinate : y_Coordinates) {
            if (y_Coordinate <= 0 || y_Coordinate > canvas.getHeight() - 2) {
                throw new InvalidCoordinateException("Y Coordinate is out of canvas.");
            }
        }
    }*/
}
