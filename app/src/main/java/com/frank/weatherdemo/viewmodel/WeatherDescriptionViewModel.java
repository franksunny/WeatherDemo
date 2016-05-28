package com.frank.weatherdemo.viewmodel;

import com.frank.weatherdemo.model.WeatherDescription;

/**
 * Created by frank on 26/05/16.
 *
 */
public class WeatherDescriptionViewModel {
    public final WeatherDescription mWeatherDescription;

    public WeatherDescriptionViewModel(WeatherDescription weatherDescription) {
        this.mWeatherDescription = weatherDescription;
    }

    public String getContent() {
        return mWeatherDescription.tipt + ": " + mWeatherDescription.zs;
    }

    public String getDes() {
        return mWeatherDescription.des;
    }

    public String getTitle() {
        return mWeatherDescription.title;
    }
}
