package com.frank.weatherdemo.viewmodel;

import com.frank.weatherdemo.model.WeatherForecast;

/**
 * Created by frank on 26/05/16.
 *
 */
public class WeatherForecastViewModel {
    public final WeatherForecast mWeatherForecast;

    public WeatherForecastViewModel(WeatherForecast weatherForecast) {
        mWeatherForecast = weatherForecast;
    }
}
