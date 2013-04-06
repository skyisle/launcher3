package com.android.launcher2;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;

/**
 * Created with IntelliJ IDEA. User: skyisle Date: 4/5/13 Time: 11:39 오후 To change this template use
 * File | Settings | File Templates.
 */
public class ActivityCompat {
    public static void startActivity(Activity activity, Intent intent, Bundle bundle) {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
            activity.startActivity(intent, bundle);
        } else {
            activity.startActivity(intent);
        }
    }
}
