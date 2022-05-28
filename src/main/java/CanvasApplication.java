package main.java;

import main.java.command.Command;
import main.java.command.CommandFactory;

import java.util.Scanner;

public class CanvasApplication {
    public static Scanner input = new Scanner(System.in);
    public static void init() {
        Command command;
        System.out.println("Welcome to Canvas");
        while (true) {
            try {
                System.out.println("Enter the command : ");
                command = CommandFactory.getCommand(input.nextLine());
                command.execute();
                Canvas.getInstance().printCanvas();
            } catch (Exception ex) {
                System.out.println("Error : " + ex.getMessage());
            }
        }
    }
}
