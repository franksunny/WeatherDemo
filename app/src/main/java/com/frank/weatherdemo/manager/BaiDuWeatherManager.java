package com.frank.weatherdemo.manager;

import com.frank.weatherdemo.net.ApiConstants;
import com.frank.weatherdemo.net.ApiManager;
import com.frank.weatherdemo.net.response.WeatherGetResponse;

import rx.Observable;
import rx.schedulers.Schedulers;

/**
 * Created by frank on 26/05/16.
 * 作为业务的单例
 */
public class BaiDuWeatherManager {
    private static volatile BaiDuWeatherManager ourInstance;

    public static BaiDuWeatherManager getInstance() {
        BaiDuWeatherManager temp = ourInstance;
        if (ourInstance == null){
            synchronized (BaiDuWeatherManager.class){
                temp = ourInstance;

                if (ourInstance == null){
                    temp = new BaiDuWeatherManager();
                    ourInstance = temp;
                }
            }
        }
        return temp;
    }

    private BaiDuWeatherManager() {
    }

    public Observable<WeatherGetResponse> weatherGet(final String location) {
        return ApiManager.getInstance().getApiClient().weatherGet(location, ApiConstants.DEFAULT_OUTPUT_FORMAT,
                ApiConstants.BAI_DU_API_KEY)
                .subscribeOn(Schedulers.io());
    }
}
