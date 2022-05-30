package main.java;

import main.java.draw.ConsoleInput;
import main.java.draw.Input;
import main.java.draw.FileInput;

import static main.java.constants.CanvasConstants.BLANK;
import static main.java.constants.CanvasConstants.WELCOME_MESSAGE;

/**
 * CanvasManager is responsible for deciding the application type passed in the command line arguments
 * and start that type.
 * Application type is basically the source of input for the application.
 * Default is console input.
 */
public class CanvasManager {
    public static void init(String[] args) {
        System.out.println(WELCOME_MESSAGE);
        switch (getApplicationType(args).toLowerCase()) {
            case "console":
                getConsole().start(args);
                break;
            case "file":
                getFile().start(args);
                break;
            default:
                getConsole().start(args);
        }
    }

    private static Input<String[]> getConsole() {
        return new ConsoleInput();
    }

    private static Input<String[]> getFile() {
        return new FileInput();
    }

    private static String getApplicationType(String[] args) {
        if (args != null && args.length > 0) {
            return args[0];
        }
        return BLANK;
    }
}
