package main.java;

import static main.java.constants.CanvasConstants.*;

public class Canvas {

    private static Canvas instance;
    private int height, width;
    private int[][] canvasPixels;

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
                printPixel(canvasPixels[y][x]);
            }
            System.out.println();
        }
    }

    private static void printPixel(int content) {
        switch (content) {
            case DASH:
                System.out.print("_");
                break;
            case PIPE:
                System.out.print("|");
                break;
            case LINE:
                System.out.print("x");
                break;
            case 0:
                System.out.print(" ");
                break;
        }

    }

    public void initializeCanvas(int height, int width) {
        this.height = height + 2;
        this.width = width + 2;
        canvasPixels = new int[this.height][this.width];
        for (int y = 0; y < this.height; y++) {
            for (int x = 0; x < this.width; x++) {
                if (y == 0 || y == this.height - 1) {
                    canvasPixels[y][x] = DASH;
                } else if (x == 0 || x == this.width - 1) {
                    canvasPixels[y][x] = PIPE;
                }
            }
        }
    }

    public void drawLine(int x1, int y1, int x2, int y2) {
        for (int y = 1; y < this.height - 1; y++) {
            for (int x = 1; x < this.width - 1; x++) {
                if ((y >= y1 && y <= y2) && (x >= x1 && x <= x2)) {
                    canvasPixels[y][x] = LINE;
                }
            }
        }
    }

    public void drawRectangle(int x1, int y1, int x2, int y2) {
        for (int y = 1; y < this.height - 1; y++) {
            for (int x = 1; x < this.width - 1; x++) {
                if ((y >= y1 && y <= y2) && (x == x1 || x == x2)) {
                    canvasPixels[y][x] = LINE;
                } else if ((y == y1 || y == y2) && (x >= x1 && x <= x2)) {
                    canvasPixels[y][x] = LINE;
                }
            }
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

    public int[][] getCanvasPixels() {
        return canvasPixels;
    }

    public void setCanvasPixels(int[][] canvasPixels) {
        this.canvasPixels = canvasPixels;
    }
}
