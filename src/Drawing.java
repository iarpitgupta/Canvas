import exceptions.CanvasNotFoundException;
import exceptions.CommandNotFoundException;
import exceptions.InvalidCoordinateException;
import exceptions.InvalidParametersException;

import java.util.Scanner;

public class Drawing {
    private Command command = new Command();
    public static Scanner input = new Scanner(System.in);

    public static void main(String[] args) throws InvalidParametersException, CommandNotFoundException, CanvasNotFoundException, InvalidCoordinateException {
        Drawing drawing = new Drawing();
        System.out.println("Welcome to Canvas");
        while (true) {
            try {
                System.out.println("Enter the command : ");
                drawing.getCommand().setCommand(input.nextLine());
                drawing.getCommand().executeCommand();
            } catch (Exception ex) {
                System.out.println("Error : " + ex.getMessage());
            }
        }
    }

    public Command getCommand() {
        return command;
    }

    public void setCommand(Command command) {
        this.command = command;
    }
}
