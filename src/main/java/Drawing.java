package main.java;

import main.java.exceptions.CanvasNotFoundException;
import main.java.exceptions.CommandNotFoundException;
import main.java.exceptions.InvalidCoordinateException;
import main.java.exceptions.InvalidParametersException;

import java.util.Scanner;

public class Drawing {
    public static void main(String[] args) throws InvalidParametersException, CommandNotFoundException, CanvasNotFoundException, InvalidCoordinateException {
        CanvasApplication.init();
    }
}
