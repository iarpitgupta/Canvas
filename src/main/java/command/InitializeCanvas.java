package main.java.command;

import main.java.Canvas;
import main.java.exceptions.CanvasDimensionException;
import main.java.exceptions.InvalidParametersException;

import static main.java.constants.CanvasConstants.*;
import static main.java.utils.CanvasUtil.parseInputToInt;

/**
 * InitializeCanvas class is responsible for validating input
 * and initializing canvas.
 */
public class InitializeCanvas implements Command {

    Canvas canvas;
    String[] commandParameters;

    int height, width;

    InitializeCanvas(Canvas canvas, String[] commandParameters) {
        this.canvas = canvas;
        this.commandParameters = commandParameters;
    }

    @Override
    public void execute() throws InvalidParametersException, CanvasDimensionException {
        if (validateParameters(commandParameters)) {
            height = height + CANVAS_BORDER;
            width = width + CANVAS_BORDER;
            initializeCanvas(width, height);
        }
    }

    @Override
    public boolean validateParameters(String[] commandParameters) throws InvalidParametersException, CanvasDimensionException {
        if (commandParameters.length != 3) {
            throw new InvalidParametersException(INVALID_PARAMETERS);
        }
        width = parseInputToInt(commandParameters[1]);
        height = parseInputToInt(commandParameters[2]);
        if (height <= 0 || width <= 0) {
            throw new CanvasDimensionException(CANNOT_CREATE_CANVAS_WITH_1_WIDTH_HEIGHT);
        }
        return true;
    }

    private void initializeCanvas(int width, int height) {
        canvas.setHeight(height);
        canvas.setWidth(width);
        canvas.setCanvasPixels(new String[height][width]);
        for (int y_AxisPoint = 0; y_AxisPoint < height; y_AxisPoint++) {
            for (int x_AxisPoint = 0; x_AxisPoint < width; x_AxisPoint++) {
                if (y_AxisPoint == 0 || y_AxisPoint == height - 1) {
                    canvas.getCanvasPixels()[y_AxisPoint][x_AxisPoint] = DASH;
                } else if (x_AxisPoint == 0 || x_AxisPoint == width - 1) {
                    canvas.getCanvasPixels()[y_AxisPoint][x_AxisPoint] = PIPE;
                } else {
                    canvas.getCanvasPixels()[y_AxisPoint][x_AxisPoint] = BLANK;
                }
            }
        }
    }
}
