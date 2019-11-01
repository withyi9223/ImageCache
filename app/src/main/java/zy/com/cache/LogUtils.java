package zy.com.cache;

import android.util.Log;

public class LogUtils {


    private static String TAG = "LogUtils";
    private static boolean isLog = BuildConfig.DEBUG;

    public void setTAG(String TAG) {
        LogUtils.TAG = TAG;
    }

    public static void e(String msg) {
        if (isLog) {
            Log.e(TAG, msg);
        }
    }

    public static void d(String msg) {
        if (isLog) {
            Log.d(TAG, msg);
        }
    }

    public static void i(String msg) {
        if (isLog) {
            Log.i(TAG, msg);
        }
    }
}
