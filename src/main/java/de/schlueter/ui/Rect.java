package de.schlueter.ui;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.shape.Rectangle;

/**
 * Rect
 */
public class Rect extends Rectangle {
    GraphicsContext gc;
    private int gap = 10;
    private int widthRect = 50;
    private int indexNumber;
    private int randomYPositions;

    public Rect(GraphicsContext gc, int indexNumber, int randomYPositions) {
        this.gc = gc;
        this.indexNumber = indexNumber;
        this.randomYPositions = randomYPositions;
    }

    public void draw() {
        double startY = gc.getCanvas().getHeight() - randomYPositions;
        gc.fillRect(gap * indexNumber + 1 + widthRect * indexNumber, startY, widthRect,
                    randomYPositions);
    }
}
