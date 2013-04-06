package com.android.launcher2;

import android.os.Build;
import android.view.ViewTreeObserver;

/**
 * Created with IntelliJ IDEA. User: skyisle Date: 4/5/13 Time: 9:20 오후 To change this template use
 * File | Settings | File Templates.
 */
public class ViewTreeObserverCompat {
    public static void removeOnGlobalLayoutListener(ViewTreeObserver observer,
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener) {
        if (Build.VERSION.SDK_INT >= 16) {
            observer.removeOnGlobalLayoutListener(onGlobalLayoutListener);
        } else {
            observer.removeGlobalOnLayoutListener(onGlobalLayoutListener);
        }
    }
}
