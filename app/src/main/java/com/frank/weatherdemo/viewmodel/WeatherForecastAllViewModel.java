package com.frank.weatherdemo.viewmodel;

import com.frank.weatherdemo.model.WeatherForecast;

import java.util.List;

/**
 * Created by frank on 26/05/16.
 *
 */
public class WeatherForecastAllViewModel {
    public final List<WeatherForecast> mWeatherForecastList;

    public WeatherForecastAllViewModel(List<WeatherForecast> weatherForecastList) {
        this.mWeatherForecastList = weatherForecastList;
    }

    @SuppressWarnings("unused")
    public WeatherForecastViewModel getWeatherForecast(int i){
        if (mWeatherForecastList != null && mWeatherForecastList.size() > i && i >= 0){
            return new WeatherForecastViewModel(mWeatherForecastList.get(i));
        }

        return null;
    }
}
