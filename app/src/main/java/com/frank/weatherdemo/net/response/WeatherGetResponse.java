package com.frank.weatherdemo.net.response;

import com.frank.weatherdemo.model.WeatherResult;
import com.frank.weatherdemo.net.response.base.BaseResponse;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by frank on 26/05/16.
 *
 */
public class WeatherGetResponse extends BaseResponse {
    @SerializedName("results")
    @Expose
    private final List<WeatherResult> weatherResultList = null;

    @SuppressWarnings("ConstantConditions")
    public WeatherResult getWeatherResult() {
        if (weatherResultList != null && weatherResultList.size() > 0) {
            return weatherResultList.get(0);
        }

        return null;
    }
}
