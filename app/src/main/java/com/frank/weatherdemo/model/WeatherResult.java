package com.frank.weatherdemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by frank on 26/05/16.
 *
 */
public class WeatherResult {
    public static final int DAY_INDEX_1 = 0;
    public static final int DAY_INDEX_2 = DAY_INDEX_1 + 1;
    public static final int DAY_INDEX_3 = DAY_INDEX_2 + 1;
    @SuppressWarnings("unused")
    public static final int DAY_INDEX_4 = DAY_INDEX_3 + 1;

    @SerializedName("currentCity")
    @Expose
    public final String currentCity = null;

    @SuppressWarnings("unused")
    @SerializedName("pm25")
    @Expose
    public final String pm25 = null;

    @SerializedName("weather_data")
    @Expose
    public final List<WeatherForecast> weatherForecastList = null;

    @SerializedName("index")
    @Expose
    public final List<WeatherDescription> weatherDescriptionList = null;
}
