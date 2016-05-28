package com.frank.weatherdemo.utils;


import android.util.Log;

import com.frank.weatherdemo.BuildConfig;


public abstract class LogUtil {
    private static final String LOG_PREFIX = "weather_";
    private static final int LOG_PREFIX_LENGTH = LOG_PREFIX.length();
    private static final int MAX_LOG_TAG_LENGTH = 23;

    private LogUtil() {
    }

    private static String makeLogTag(String str) {
        if (str.length() > MAX_LOG_TAG_LENGTH - LOG_PREFIX_LENGTH) {
            return LOG_PREFIX + str.substring(0, MAX_LOG_TAG_LENGTH - LOG_PREFIX_LENGTH - 1);
        }

        return LOG_PREFIX + str;
    }

    /**
     * Don't use this when obfuscating class names!
     */
    public static String makeLogTag(Class cls) {
        return makeLogTag(cls.getSimpleName());
    }

    @SuppressWarnings("unused")
    public static void LOGD(final String tag, String message) {
        //noinspection PointlessBooleanExpression,ConstantConditions
        if (BuildConfig.DEBUG || Log.isLoggable(tag, Log.DEBUG)) {
            Log.d(tag, message);
        }
    }

    @SuppressWarnings("unused")
    public static void LOGD(@SuppressWarnings("SameParameterValue") final String tag, @SuppressWarnings("SameParameterValue") String message, Throwable cause) {
        //noinspection PointlessBooleanExpression,ConstantConditions
        if (BuildConfig.DEBUG || Log.isLoggable(tag, Log.DEBUG)) {
            Log.d(tag, message, cause);
        }
    }

    @SuppressWarnings("unused")
    public static void LOGV(@SuppressWarnings("SameParameterValue") final String tag, String message) {
        //noinspection PointlessBooleanExpression,ConstantConditions
        if (BuildConfig.DEBUG && Log.isLoggable(tag, Log.VERBOSE)) {
            Log.v(tag, message);
        }
    }

    @SuppressWarnings("unused")
    public static void LOGV(final String tag, String message, Throwable cause) {
        //noinspection PointlessBooleanExpression,ConstantConditions
        if (BuildConfig.DEBUG && Log.isLoggable(tag, Log.VERBOSE)) {
            Log.v(tag, message, cause);
        }
    }

    @SuppressWarnings("unused")
    public static void LOGI(final String tag, String message) {
        Log.i(tag, message);
    }

    @SuppressWarnings("unused")
    public static void LOGI(final String tag, String message, Throwable cause) {
        Log.i(tag, message, cause);
    }

    @SuppressWarnings("unused")
    public static void LOGW(final String tag, String message) {
        Log.w(tag, message);
    }

    @SuppressWarnings("unused")
    public static void LOGW(final String tag, String message, Throwable cause) {
        Log.w(tag, message, cause);
    }

    @SuppressWarnings("unused")
    public static void LOGE(final String tag, String message) {
        Log.e(tag, message);
    }

    @SuppressWarnings("unused")
    public static void LOGE(final String tag, String message, Throwable cause) {
        Log.e(tag, message, cause);
    }
}
