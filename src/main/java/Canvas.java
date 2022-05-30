package main.java;

/**
 * Canvas class is responsible for creating canvas instance, holding its properties and printing canvas.
 * Only single instance of Canvas can exist in whole application.
 */
public class Canvas {

    private static Canvas instance;
    private int height, width;
    private String[][] canvasPixels;

    private Canvas() {
    }

    public static Canvas getInstance() {
        synchronized (Canvas.class) {
            if (instance == null) {
                instance = new Canvas();
            }
        }
        return instance;
    }

    public void printCanvas() {
        for (int y = 0; y < height; y++) {
            for (int x = 0; x < width; x++) {
                System.out.print((canvasPixels[y][x]));
            }
            System.out.println();
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public String[][] getCanvasPixels() {
        return canvasPixels;
    }

    public void setCanvasPixels(String[][] canvasPixels) {
        this.canvasPixels = canvasPixels;
    }
}
