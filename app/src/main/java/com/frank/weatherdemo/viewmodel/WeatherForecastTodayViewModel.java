package com.frank.weatherdemo.viewmodel;

import android.databinding.BindingAdapter;
import android.net.Uri;
import android.text.TextUtils;

import com.facebook.drawee.view.SimpleDraweeView;
import com.frank.weatherdemo.model.WeatherResult;

/**
 * Created by frank on 26/05/16.
 *
 */
public class WeatherForecastTodayViewModel {
    public final WeatherResult mWeatherResult;

    public WeatherForecastTodayViewModel(WeatherResult weatherResult) {
        mWeatherResult = weatherResult;
    }

    @SuppressWarnings("unused")
    @BindingAdapter({"imageUrl"})
    public static void loadImageUrl(SimpleDraweeView view, String imageUrl) {
        if (!TextUtils.isEmpty(imageUrl)) {
            Uri uri = Uri.parse(imageUrl);
            view.setImageURI(uri);
        }
    }
}
