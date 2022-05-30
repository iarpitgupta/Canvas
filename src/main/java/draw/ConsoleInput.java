package main.java.draw;

import main.java.Canvas;
import main.java.command.CommandFactory;

import java.util.Scanner;

import static main.java.constants.CanvasConstants.ERROR_MESSAGE;
import static main.java.constants.CanvasConstants.INPUT_MESSAGE;

/**
 * ConsoleInput class is responsible for taking input from console.
 */
public class ConsoleInput implements Input<String[]> {

    public static Scanner input = new Scanner(System.in);

    @Override
    public void start(String[] args) {
        while (true) {
            try {
                System.out.println(INPUT_MESSAGE);
                CommandFactory.getCommand(input.nextLine()).execute();
                Canvas.getInstance().printCanvas();
            } catch (Exception ex) {
                System.out.println(ERROR_MESSAGE + ex.getMessage());
            }
        }
    }
}
