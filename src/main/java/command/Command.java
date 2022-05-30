package main.java.command;

public interface Command {

    void execute() throws Exception;

    boolean validateParameters(String[] commandParameters) throws Exception;

}