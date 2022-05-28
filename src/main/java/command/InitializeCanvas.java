package main.java.command;

import main.java.Canvas;
import main.java.exceptions.InvalidParametersException;

import static main.java.constants.CanvasConstants.*;
import static main.java.utils.CanvasUtil.parseInputToInt;

public class InitializeCanvas implements Command {

    Canvas canvas;
    String[] commandParameters;

    InitializeCanvas(Canvas canvas, String[] commandParameters) {
        this.canvas = canvas;
        this.commandParameters = commandParameters;
    }

    @Override
    public void execute() throws InvalidParametersException {
        if (validateParameters(commandParameters)) {
            int width = parseInputToInt(commandParameters[1]);
            int height = parseInputToInt(commandParameters[2]);
            canvas.setHeight(height + 2);
            canvas.setWidth(width + 2);
            canvas.setCanvasPixels(new int[canvas.getHeight()][canvas.getWidth()]);
            for (int y = 0; y < canvas.getHeight(); y++) {
                for (int x = 0; x < canvas.getWidth(); x++) {
                    if (y == 0 || y == canvas.getHeight() - 1) {
                        canvas.getCanvasPixels()[y][x] = DASH;
                    } else if (x == 0 || x == canvas.getWidth() - 1) {
                        canvas.getCanvasPixels()[y][x] = PIPE;
                    }
                }
            }
        }
    }

    @Override
    public boolean validateParameters(String[] commandParameters) throws InvalidParametersException {
        if (commandParameters.length != 3) {
            throw new InvalidParametersException(INVALID_PARAMETERS);
        }
        return true;
    }
}
