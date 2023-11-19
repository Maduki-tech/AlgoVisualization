package de.schlueter.algorithm;

import java.util.List;

import de.schlueter.ui.Rect;

/**
 * BubbleSort
 */
public class BubbleSort {
    
        public static void sort(List<Rect> rects) {
            int n = rects.size();
            int temp = 0;
    
            for (int i = 0; i < n; i++) {
                for (int j = 1; j < (n - 1); j++) {
                    if (rects.get(j - 1).getHeight() > rects.get(j).getHeight()) {
                        temp = (int) rects.get(j - 1).getHeight();
                        rects.get(j - 1).setHeight(rects.get(j).getHeight());
                        rects.get(j).setHeight(temp);
                    }
                }
            }
        }
}
