package main.java.command;

import main.java.Canvas;
import main.java.exceptions.*;

import static main.java.constants.CanvasConstants.*;
import static main.java.utils.CanvasUtil.*;

/**
 * BucketFill class is responsible for validating and paint the canvas with
 * the provided colour.
 */
public class BucketFill implements Command {

    Canvas canvas;
    String[] commandParameters;
    int x_point, y_point;
    String colour;

    BucketFill(Canvas canvas, String[] commandParameters) {
        this.canvas = canvas;
        this.commandParameters = commandParameters;
    }

    @Override
    public void execute() throws InvalidParametersException, InvalidCoordinateException, CanvasNotFoundException, PaintOnLineException, ColourDoesNotExistException {
        if (validateParameters(commandParameters)) {
            int x = parseInputToInt(commandParameters[1]);
            int y = parseInputToInt(commandParameters[2]);
            String colour = commandParameters[3];
            validateXCoordinates(x);
            validateYCoordinates(y);
            paint(x, y, colour, canvas.getWidth() - CANVAS_BORDER, canvas.getHeight() - CANVAS_BORDER);
        }
    }

    @Override
    public boolean validateParameters(String[] commandParameters) throws InvalidParametersException, CanvasNotFoundException, PaintOnLineException, ColourDoesNotExistException {
        if (canvas.getCanvasPixels() == null) {
            throw new CanvasNotFoundException(CANVAS_NOT_INITIALIZED);
        }
        if (commandParameters.length != 4) {
            throw new InvalidParametersException(INVALID_PARAMETERS);
        }
        parseParameters(commandParameters);
        if (canvas.getCanvasPixels()[y_point][x_point].equals(LINE)) {
            throw new PaintOnLineException(CANNOT_PAINT_ON_LINE);
        }
        if (colour.equalsIgnoreCase(LINE)){
            throw new ColourDoesNotExistException("Colour " + colour + " does not exists.");
        }
        return true;
    }

    void paint(int x, int y, String colour, int x_max, int y_max) {
        if (x < 1 || y < 1 || x > x_max || y > y_max || isLine(x, y, colour)) {
            return;
        }
        canvas.getCanvasPixels()[y][x] = colour;
        paint(x - 1, y, colour, x_max, y_max);
        paint(x + 1, y, colour, x_max, y_max);
        paint(x, y - 1, colour, x_max, y_max);
        paint(x, y + 1, colour, x_max, y_max);
    }

    boolean isLine(int x, int y, String colour) {
        return canvas.getCanvasPixels()[y][x].equals(LINE) || canvas.getCanvasPixels()[y][x].equals(colour);
    }

    private void parseParameters(String[] commandParameters) throws InvalidParametersException {
        x_point = parseInputToInt(commandParameters[1]);
        y_point = parseInputToInt(commandParameters[2]);
        colour = commandParameters[3];
    }
}
