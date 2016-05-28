package com.frank.weatherdemo.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by frank on 26/05/16.
 *
 */
public class WeatherDescription {
    @SerializedName("des")
    @Expose
    public final String des = null;

    @SerializedName("tipt")
    @Expose
    public final String tipt = null;

    @SerializedName("title")
    @Expose
    public final String title = null;

    @SerializedName("zs")
    @Expose
    public final String zs = null;
}
