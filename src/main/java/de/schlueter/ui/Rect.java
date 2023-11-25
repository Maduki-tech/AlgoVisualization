package de.schlueter.UI;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;

/**
 * Rect
 */
public class Rect {
    private int HEIGHT = 200;
    private int widthRect = 20;
    private int xOffset = 25;
    private int randomHeight;
    private int currentXOffset;

    public Rect() {
        randomHeight = randomHeight(1, HEIGHT-10);
    }

    private int randomHeight(int min, int max){
        return (int) ((Math.random() * (max - min)) + min);
    }
    public void draw(GraphicsContext gc, int factor) {
        gc.setFill(Color.BLACK);
        this.currentXOffset = xOffset * factor;
        gc.fillRect(this.currentXOffset, 0, this.widthRect, this.randomHeight);
    }

    public int getHeight() {
        return randomHeight;
    }

}
