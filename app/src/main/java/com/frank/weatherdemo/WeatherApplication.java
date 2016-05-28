package com.frank.weatherdemo;

import android.app.Application;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.frank.weatherdemo.utils.GSONUtil;

import java.lang.reflect.Type;
import java.util.HashMap;

import static com.frank.weatherdemo.utils.LogUtil.makeLogTag;

/**
 * Created by frank on 26/05/16.
 *
 */
public class WeatherApplication extends Application {
    @SuppressWarnings("unused")
    private static final String TAG = makeLogTag(WeatherApplication.class);


    @Override
    public void onCreate() {
        super.onCreate();

        Fresco.initialize(getApplicationContext());

        initGSONUtil();
    }

    private void initGSONUtil() {
        HashMap<Type, Object> typeAdapterHashMap = new HashMap<>();

        GSONUtil.init(typeAdapterHashMap);
    }
}
