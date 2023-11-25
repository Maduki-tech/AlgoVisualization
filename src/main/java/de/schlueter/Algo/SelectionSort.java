package de.schlueter.Algo;

import de.schlueter.UI.Rect;
import java.util.List;

/**
 * SelectionSort
 */
public class SelectionSort {
    public static List<Rect> sort(List<Rect> rects, int index) {
        int minPos = index;
        for (int i = index + 1; i < rects.size(); i++) {
            if (rects.get(i).getHeight() < rects.get(minPos).getHeight()) {
                minPos = i;
            }
        }

        Rect temp = rects.get(index);
        rects.set(index, rects.get(minPos));
        rects.set(minPos, temp);

        return rects;
    }
}
