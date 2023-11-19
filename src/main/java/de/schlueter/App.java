package de.schlueter;

import de.schlueter.ui.Rect;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.stage.Stage;
/**
 * Hello world!
 *
 */
public class App extends Application {
    private static int WIDTH = 800;
    private static int HEIGHT = 600;
    private static int numberOfElements = 30;
    List<Rect> rects = new ArrayList<>();

    private int bubbleSortIndex = 0;
    private boolean isSorted = false;

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) {
        Group root = new Group();
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        final Canvas canvas = new Canvas(WIDTH, HEIGHT);
        canvas.widthProperty().bind(scene.widthProperty());
        canvas.heightProperty().bind(scene.heightProperty());

        GraphicsContext gc = canvas.getGraphicsContext2D();
        root.getChildren().add(canvas);
        initializeRects(gc);

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                if (!isSorted) {
                    isSorted = BubbleSortStep();
                    draw(gc);
                }else{
                    System.out.println("Done!");
                    stop();
                }
            }
        }.start();

        primaryStage.setTitle("BubbleSort");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    protected boolean BubbleSortStep() {
        boolean swapped = false;
        if (bubbleSortIndex < rects.size() - 1) {
            if (rects.get(bubbleSortIndex).getValue() > rects.get(bubbleSortIndex + 1).getValue()) {
                swap(rects, bubbleSortIndex, bubbleSortIndex + 1);
                swapped = true;
            }
            bubbleSortIndex++;
        } else {
            bubbleSortIndex = 0;
        }
        return false;
    }

    private void swap(List<Rect> rects, int firstIndex, int secondIndex) {
        Rect temp = rects.get(firstIndex);
        rects.set(firstIndex, rects.get(secondIndex));
        rects.set(secondIndex, temp);

        // Update positions
        rects.get(firstIndex).setX(firstIndex);
        rects.get(secondIndex).setX(secondIndex);
    }
    private void initializeRects(GraphicsContext gc) {
        for (int i = 0; i < numberOfElements; i++) {
            int randomYPositions = ((int)(Math.random() * 500 + 100));
            rects.add(new Rect(gc, i, randomYPositions));
        }
    }

    private void draw(GraphicsContext gc) {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());
        for (Rect rect : rects) {
            rect.draw();
        }
    }
}
