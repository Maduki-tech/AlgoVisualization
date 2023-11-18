package de.schlueter;

import java.util.ArrayList;
import java.util.List;

import de.schlueter.ui.Rect;
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

    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage primaryStage) throws Exception {
        Group root = new Group();
        Scene scene = new Scene(root, WIDTH, HEIGHT);

        final Canvas canvas = new Canvas(800, 500);

        canvas.widthProperty().bind(scene.widthProperty());
        canvas.heightProperty().bind(scene.heightProperty());

        GraphicsContext gc = canvas.getGraphicsContext2D();

        scene.widthProperty().addListener((obs, oldVal, newVal) -> draw(gc));
        scene.heightProperty().addListener((obs, oldVal, newVal) -> draw(gc));

        root.getChildren().add(canvas);

        primaryStage.setTitle("Hello World");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void draw(GraphicsContext gc) {
        gc.clearRect(0, 0, gc.getCanvas().getWidth(), gc.getCanvas().getHeight());

        for (int i = 0; i < numberOfElements; i++) {
            int randomYPositions = ((int)(Math.random() * 500 + 100));
            rects.add(new Rect(gc, i, randomYPositions));
            rects.get(i).draw();
        }

    }
}
