package de.schlueter.Algo;

import de.schlueter.UI.Rect;
import java.util.List;

/**
 * BubbleSort
 */
public class BubbleSort {
    public static List<Rect> sort(List<Rect> rects, int bubbleSortIndex) {
        if (bubbleSortIndex < rects.size() - 1) {
            if (rects.get(bubbleSortIndex).getHeight()
                > rects.get(bubbleSortIndex + 1).getHeight()) {
                swap(rects, bubbleSortIndex);
            }
        } else {
            return rects;
        }
        return rects;
    }

    private static void swap(List<Rect> rects, int bubbleSortIndex) {
        Rect temp = rects.get(bubbleSortIndex);
        rects.set(bubbleSortIndex, rects.get(bubbleSortIndex + 1));
        rects.set(bubbleSortIndex + 1, temp);
    }
}
