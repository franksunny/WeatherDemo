package com.frank.weatherdemo.ui.activity.base;

import com.trello.rxlifecycle.components.support.RxAppCompatActivity;

import static com.frank.weatherdemo.utils.LogUtil.makeLogTag;

/**
 * Created by frank on 26/05/16.
 *
 */
public class BaseActivity extends RxAppCompatActivity {
    @SuppressWarnings("unused")
    private static final String TAG = makeLogTag(BaseActivity.class);

    public boolean isPaused;

    protected void onResume() {
        super.onResume();
        this.isPaused = false;
    }

    protected void onPause() {
        super.onPause();
        this.isPaused = true;
    }
}
