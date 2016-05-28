package com.frank.weatherdemo.net;

import com.frank.weatherdemo.net.response.WeatherGetResponse;

import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by frank on 26/05/16.
 *
 */
public interface ApiService {
    @FormUrlEncoded
    @POST(ApiConstants.WEATHER_GET)
    Observable<WeatherGetResponse> weatherGet(
            @Field("location") String location,
            @Field("output") String output,
            @Field("ak") String ak
    );
}
