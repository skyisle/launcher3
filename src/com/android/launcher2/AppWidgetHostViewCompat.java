package com.android.launcher2;

import com.alanjeon.dalinaumlauncher.R;

import android.appwidget.AppWidgetHostView;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.*;
import android.content.res.Resources;
import android.graphics.Rect;
import android.os.Build;

/**
 * Created with IntelliJ IDEA. User: skyisle Date: 13. 4. 5. Time: PM 6:58 To change this template
 * use File | Settings | File Templates.
 */
public class AppWidgetHostViewCompat {
    public static Rect getDefaultPaddingForWidget(Context context, ComponentName component,
            Rect padding) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            return AppWidgetHostView.getDefaultPaddingForWidget(context, component, padding);
        } else {
            PackageManager packageManager = context.getPackageManager();
            android.content.pm.ApplicationInfo appInfo;

            if (padding == null) {
                padding = new Rect(0, 0, 0, 0);
            } else {
                padding.set(0, 0, 0, 0);
            }

            try {
                appInfo = packageManager.getApplicationInfo(component.getPackageName(), 0);
            } catch (PackageManager.NameNotFoundException e) {
                // if we can't find the package, return 0 padding
                return padding;
            }

            if (appInfo.targetSdkVersion >= Build.VERSION_CODES.ICE_CREAM_SANDWICH) {
                Resources r = context.getResources();
                padding.left = r.getDimensionPixelSize(R.dimen.default_app_widget_padding_left);
                padding.right = r.getDimensionPixelSize(R.dimen.default_app_widget_padding_right);
                padding.top = r.getDimensionPixelSize(R.dimen.default_app_widget_padding_top);
                padding.bottom = r.getDimensionPixelSize(R.dimen.default_app_widget_padding_bottom);
            }
            return padding;
        }

    }
}
