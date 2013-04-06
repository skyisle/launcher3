package com.android.launcher2;

import android.graphics.Point;
import android.os.Build;
import android.view.Display;

/**
 * Created with IntelliJ IDEA. User: skyisle Date: 13. 4. 5. Time: PM 6:49 To change this template
 * use File | Settings | File Templates.
 */
public class DisplayCompt {
    public static void getCurrentSizeRange(Display display, Point smallestSize, Point largestSize) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            display.getCurrentSizeRange(smallestSize, largestSize);
        } else {
            display.getSize(smallestSize);
            display.getSize(largestSize);
        }
    }
}
