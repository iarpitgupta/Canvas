import exceptions.CanvasNotFoundException;
import exceptions.CommandNotFoundException;
import exceptions.InvalidCoordinateException;
import exceptions.InvalidParametersException;

import static constants.CanvasConstants.*;

public class Command {

    private String command;
    public Canvas canvas = new Canvas();

    public String getCommand() {
        return command;
    }

    public void setCommand(String command) {
        this.command = command;
    }

    public String[] splitCommand() {
        return command.trim().split(BLANK);
    }

    public void executeCommand() throws CommandNotFoundException, InvalidParametersException, InvalidCoordinateException, CanvasNotFoundException {
        if (command == null || command.isBlank()) {
            throw new CommandNotFoundException("No command found");
        } else {
            String[] commandArray = splitCommand();
            switch (commandArray[0].toLowerCase()) {
                case "c":
                    initializeCanvas(commandArray);
                    break;
                case "l":
                    drawLine(commandArray);
                    break;
                case "r":
                    drawRectangle(commandArray);
                    break;
                case "q":
                    quitApplication(commandArray);
            }
            canvas.printCanvas();
        }
    }

    private void drawLine(String[] commandArray) throws InvalidParametersException, InvalidCoordinateException, CanvasNotFoundException {
        if (validateLineCommand(commandArray)) {
            int x1 = parseInputToInt(commandArray[1]);
            validateXAxisPoint(x1);
            int y1 = parseInputToInt(commandArray[2]);
            validateYAxisPoint(y1);
            int x2 = parseInputToInt(commandArray[3]);
            validateXAxisPoint(x2);
            int y2 = parseInputToInt(commandArray[4]);
            validateYAxisPoint(y2);
            canvas.drawLine(x1, y1, x2, y2);

        }
    }

    public void drawRectangle(String[] commandArray) throws CanvasNotFoundException, InvalidParametersException, InvalidCoordinateException {
        if (validateRectangleCommand(commandArray)) {
            int x1 = parseInputToInt(commandArray[1]);
            validateXAxisPoint(x1);
            int y1 = parseInputToInt(commandArray[2]);
            validateYAxisPoint(y1);
            int x2 = parseInputToInt(commandArray[3]);
            validateXAxisPoint(x2);
            int y2 = parseInputToInt(commandArray[4]);
            validateYAxisPoint(y2);
            canvas.drawRectangle(x1, y1, x2, y2);
        }
    }

    public boolean validateRectangleCommand(String[] commandArray) throws CanvasNotFoundException, InvalidParametersException {
        if (canvas.getCanvasPixels() == null) {
            throw new CanvasNotFoundException("Canvas is not initialized.");
        }
        if (commandArray.length != 5) {
            throw new InvalidParametersException("Invalid parameters");
        }
        return true;
    }

    public void quitApplication(String[] commandArray) throws InvalidParametersException {
        if (validateQuitCommand(commandArray)) {
            System.out.println("Bye");
            System.exit(0);
        }
    }

    private void validateXAxisPoint(int x_Coordinate) throws InvalidCoordinateException {
        if (x_Coordinate > canvas.getWidth() - 2) {
            throw new InvalidCoordinateException("X Coordinate is out of canvas.");
        }
    }

    private void validateYAxisPoint(int y_Coordinate) throws InvalidCoordinateException {
        if (y_Coordinate > canvas.getHeight() - 2) {
            throw new InvalidCoordinateException("Y Coordinate is out of canvas.");
        }
    }

    private boolean validateLineCommand(String[] commandArray) throws InvalidParametersException, CanvasNotFoundException {
        if (canvas.getCanvasPixels() == null) {
            throw new CanvasNotFoundException("Canvas is not initialized.");
        }
        if (commandArray.length != 5) {
            throw new InvalidParametersException("Invalid parameters");
        }
        return true;
    }

    public void initializeCanvas(String[] commandArray) throws InvalidParametersException {
        if (validateInitializeCommand(commandArray)) {
            int width = parseInputToInt(commandArray[1]);
            int height = parseInputToInt(commandArray[2]);
            canvas.initializeCanvas(height, width);
        }
    }

    public boolean validateInitializeCommand(String[] commandArray) throws InvalidParametersException {
        if (commandArray.length != 3) {
            throw new InvalidParametersException("Invalid parameters");
        }
        return true;
    }

    public boolean validateQuitCommand(String[] commandArray) throws InvalidParametersException {
        if (commandArray.length != 1) {
            throw new InvalidParametersException("Invalid parameters");
        }
        return true;
    }

    public int parseInputToInt(String integer) throws InvalidParametersException {
        try {
            return Integer.parseInt(integer);
        } catch (NumberFormatException exception) {
            throw new InvalidParametersException("Invalid Parameters");
        }
    }

}
