package de.schlueter;

import de.schlueter.Algo.BubbleSort;
import de.schlueter.Algo.SelectionSort;
import de.schlueter.UI.Rect;
import java.util.ArrayList;
import java.util.List;
import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.stage.Stage;

public class App extends Application {
    private static int WIDTH = 400;
    private static int HEIGHT = 200;
    private List<Rect> rects = new ArrayList<Rect>();
    private boolean sorted = false;
    int index = 0;
    long lastUpdate = 0;
    private static String[] launchargs;
    private String algorithm;

    public static void main(String[] args) {
        App.launchargs = args;
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        if (launchargs.length > 0) {
            try {
                algorithm = launchargs[0];
            } catch (Exception e) {
                System.out.println("No algorithm specified");
                System.exit(0);
            }
        }

        Group root = new Group();
        Scene scene = new Scene(root, WIDTH, HEIGHT);
        final Canvas canvas = new Canvas(WIDTH, HEIGHT);

        canvas.widthProperty().bind(scene.widthProperty());
        canvas.heightProperty().bind(scene.heightProperty());

        GraphicsContext gc = canvas.getGraphicsContext2D();
        for (int i = 0; i < 20; i++) {
            rects.add(new Rect());
            rects.get(i).draw(gc, i);
        }

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                // every 3 seconds
                if (sorted) {
                    stop();
                    showAlert("sorted");
                } else {
                    if (algorithm.equals(Param.bubbleSort.toString())) {
                        runBubbleSort();
                    }
                    if(algorithm.equals(Param.selectionSort.toString())){
                        runSelectionSort();
                    }
                    checkIfSorted();
                }
                lastUpdate = now;
                gc.clearRect(0, 0, WIDTH, HEIGHT); // Clear the canvas
                for (int i = 0; i < rects.size(); i++) {
                    rects.get(i).draw(gc, i); // Redraw each rectangle at its new position
                }
            }
        };
        timer.start();

        root.getChildren().add(canvas);

        primaryStage.setTitle("BubbleSort");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    private void runBubbleSort() {
        rects = BubbleSort.sort(rects, index);
        index++;
    }

    private void runSelectionSort() {
        rects = SelectionSort.sort(rects, index);
        index++;
    }

    private void checkIfSorted() {
        if (index == rects.size() - 1) {
            index = 0;
        }
        for (int i = 0; i < rects.size() - 1; i++) {
            if (rects.get(i).getHeight() > rects.get(i + 1).getHeight()) {
                sorted = false;
                break;
            } else {
                sorted = true;
            }
        }
    }

    private void showAlert(String message) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Information Dialog");
        alert.setHeaderText(null);
        alert.setContentText(message);
        Platform.runLater(() -> alert.showAndWait().ifPresent(rs -> {
            if (rs == ButtonType.OK) {
                System.exit(0);
            }
        }));
    }
}
