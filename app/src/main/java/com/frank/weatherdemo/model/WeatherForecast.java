package com.frank.weatherdemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by frank on 26/05/16.
 *
 */
public class WeatherForecast {
    @SerializedName("date")
    @Expose
    public final String date = null;

    @SuppressWarnings("unused")
    @SerializedName("dayPictureUrl")
    @Expose
    public final String dayPictureUrl = null;

    @SuppressWarnings("unused")
    @SerializedName("nightPictureUrl")
    @Expose
    public final String nightPictureUrl = null;

    @SerializedName("temperature")
    @Expose
    public final String temperature = null;

    @SerializedName("weather")
    @Expose
    public final String weather = null;

    @SerializedName("wind")
    @Expose
    public final String wind = null;
}
