package com.android.launcher2;

import android.appwidget.AppWidgetManager;
import android.content.ComponentName;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * Created with IntelliJ IDEA. User: skyisle Date: 13. 4. 5. Time: PM 7:05 To change this template
 * use File | Settings | File Templates.
 */
public class AppWidgetManagerCompat {

    private static final String TAG = "AppWidgetManagerCompat";

    public static boolean bindAppWidgetIdIfAllowed(AppWidgetManager appWidgetManager,
            int appWidgetId,
            ComponentName cn) {
        return bindAppWidgetIdIfAllowed(appWidgetManager, appWidgetId, cn, null);
    }

    public static boolean bindAppWidgetIdIfAllowed(AppWidgetManager appWidgetManager,
            int appWidgetId,
            ComponentName cn, Bundle options) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
            return appWidgetManager.bindAppWidgetIdIfAllowed(appWidgetId, cn, options);
        } if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            return appWidgetManager.bindAppWidgetIdIfAllowed(appWidgetId, cn);
        }

        return false;
    }
}
