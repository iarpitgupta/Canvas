package main.java.command;

import main.java.Canvas;
import main.java.exceptions.CommandNotFoundException;
import main.java.exceptions.InvalidCommandException;

import static main.java.constants.CanvasConstants.INVALID_COMMAND;
import static main.java.constants.CanvasConstants.NO_COMMAND_FOUND;
import static main.java.utils.CanvasUtil.splitCommand;

public class CommandFactory {

    public static Command getCommand(String command) throws CommandNotFoundException, InvalidCommandException {
        if (command == null || command.isBlank()) {
            throw new CommandNotFoundException(NO_COMMAND_FOUND);
        } else {
            String[] commandArray = splitCommand(command);
            switch (commandArray[0].toLowerCase()) {
                case "c":
                    return new InitializeCanvas(Canvas.getInstance(), commandArray);
                case "l":
                    return new Line(Canvas.getInstance(), commandArray);
                case "r":
                    return new Rectangle(Canvas.getInstance(), commandArray);
                case "q":
                    return new Quit(commandArray);
                default:
                    throw new InvalidCommandException(INVALID_COMMAND);
            }
        }
    }
}
