package com.frank.weatherdemo.utils;

import android.app.Activity;
import android.content.Context;
import android.support.design.widget.Snackbar;
import android.text.TextUtils;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

public class Utils {

    public static void snack(Activity activity, String message) {
        if (!TextUtils.isEmpty(message)) {
            Snackbar.make(activity.findViewById(android.R.id.content), message, Snackbar.LENGTH_SHORT).show();
        }
    }

    public static void snack(Activity activity, String message, int duration) {
        if (!TextUtils.isEmpty(message)) {
            Snackbar.make(activity.findViewById(android.R.id.content), message, duration).show();
        }
    }

    @SuppressWarnings("unused")
    public static void snack(Activity activity, int resId) {
        snack(activity, activity.getString(resId));
    }

    @SuppressWarnings("unused")
    public static void snack(Activity activity, int resId, int duration) {
        snack(activity, activity.getString(resId), duration);
    }


    @SuppressWarnings("unused")
    public static void hideKeyBoard(Activity activity, View view) {
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(
                Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }
}
