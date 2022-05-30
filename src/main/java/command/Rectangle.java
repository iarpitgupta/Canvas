package main.java.command;

import main.java.Canvas;
import main.java.exceptions.CanvasNotFoundException;
import main.java.exceptions.InvalidCoordinateException;
import main.java.exceptions.InvalidParametersException;

import static main.java.constants.CanvasConstants.*;
import static main.java.utils.CanvasUtil.*;

/**
 * Rectangle class is responsible for validating input
 * and drawing rectangle on canvas.
 */
public class Rectangle implements Command {

    Canvas canvas;
    String[] commandParameters;

    int x1, y1, x2, y2;

    Rectangle(Canvas canvas, String[] commandParameters) {
        this.canvas = canvas;
        this.commandParameters = commandParameters;
    }

    @Override
    public void execute() throws InvalidParametersException, InvalidCoordinateException, CanvasNotFoundException {
        if (validateParameters(commandParameters)) {
            draw(x1, y1, x2, y2);
        }
    }

    @Override
    public boolean validateParameters(String[] commandParameters) throws InvalidParametersException, CanvasNotFoundException, InvalidCoordinateException {
        if (canvas.getCanvasPixels() == null) {
            throw new CanvasNotFoundException(CANVAS_NOT_INITIALIZED);
        }
        if (commandParameters.length != 5) {
            throw new InvalidParametersException(INVALID_PARAMETERS);
        }
        parseParameters(commandParameters);
        validateXCoordinates(x1, x2);
        validateYCoordinates(y1, y2);
        return true;
    }

    private void draw(int x1, int y1, int x2, int y2) {
        for (int y_AxisPoint = 1; y_AxisPoint < canvas.getHeight() - 1; y_AxisPoint++) {
            for (int x_AxisPoint = 1; x_AxisPoint < canvas.getWidth() - 1; x_AxisPoint++) {
                //This condition is for drawing vertical lines
                if ((y_AxisPoint > y1 && y_AxisPoint < y2) && (x_AxisPoint == x1 || x_AxisPoint == x2)) {
                    canvas.getCanvasPixels()[y_AxisPoint][x_AxisPoint] = LINE;
                }
                //This condition is for drawing horizontal lines
                else if ((y_AxisPoint == y1 || y_AxisPoint == y2) && (x_AxisPoint >= x1 && x_AxisPoint <= x2)) {
                    canvas.getCanvasPixels()[y_AxisPoint][x_AxisPoint] = LINE;
                }
            }
        }
    }

    private void parseParameters(String[] commandParameters) throws InvalidParametersException {
        x1 = parseInputToInt(commandParameters[1]);
        y1 = parseInputToInt(commandParameters[2]);
        x2 = parseInputToInt(commandParameters[3]);
        y2 = parseInputToInt(commandParameters[4]);
    }
}
