package main.java.draw;

/**
 * Input is implemented by those classes which are responsible for taking inout for application
 * and decides what to do with those inputs.
 * @param <T>
 *     Send input type in command line to decide from where the application should take the input.
 */
public interface Input<T> {
    void start(T args);
}
