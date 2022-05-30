package test.java;

import main.java.Canvas;
import main.java.command.Line;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


class LineTest {
    Line line;

    @BeforeEach
    void setUp() {
        Canvas canvas = Canvas.getInstance();
        canvas.setHeight(20);
        canvas.setWidth(10);
        String[] commandParameters = new String[]{"l 2 2 12 2"};
        line = new Line(canvas, commandParameters);
    }

    @Test
    void execute() {
    }

    @Test
    void validateParameters() {
    }
}