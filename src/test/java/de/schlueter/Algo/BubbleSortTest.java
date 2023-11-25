package de.schlueter.Algo;

import de.schlueter.UI.Rect;
import java.util.ArrayList;
import java.util.List;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import org.junit.jupiter.api.Test;

/**
 * BubbleSortTest
 */
public class BubbleSortTest {
    @Test
    public void testSort() {
        List<Rect> rects = new ArrayList<>();
        Canvas canvas = new Canvas();
        GraphicsContext gc = canvas.getGraphicsContext2D();
        int[] randomHeights = {8, 2, 6, 4, 5, 3, 7, 9, 1, 22};

        for (int i = 0; i < 10; i++) {
            rects.add(new Rect());
            rects.get(i).draw(gc, i);
            rects.get(i).setHeight(randomHeights[i]);
        }

        BubbleSort.sort(rects, gc);

        System.out.println("Sorted:");
        for (int i = 0; i < rects.size(); i++) {
            System.out.println(rects.get(i).getHeight());
        }

        for (int i = 0; i < rects.size() - 1; i++) {
            assert (rects.get(i).getHeight() <= rects.get(i + 1).getHeight());
        }
    }
}
