package com.frank.weatherdemo.net;

import com.frank.weatherdemo.utils.GSONUtil;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.frank.weatherdemo.utils.LogUtil.makeLogTag;

/**
 * Created by frank on 26/05/16.
 *
 */
public class ApiManager {
    @SuppressWarnings("unused")
    private static final String TAG = makeLogTag(ApiManager.class);

    private static volatile ApiManager ourInstance;

    private ApiService mApiService;
    private OkHttpClient mOkHttpClient;
    private Retrofit mRestAdapter;

    public static ApiManager getInstance() {
        ApiManager temp = ourInstance;
        if (ourInstance == null){
            synchronized (ApiManager.class){
                temp = ourInstance;

                if (ourInstance == null){
                    temp = new ApiManager();
                    ourInstance = temp;
                }
            }
        }

        return temp;
    }

    private ApiManager() {
        initOkHttpClient();

        initRetrofit();
    }

    private void initRetrofit() {
        mRestAdapter = new Retrofit.Builder()
                .baseUrl(ApiConstants.BASE_URL)
                .client(mOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create(GSONUtil.getGson()))
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();
    }

    private void initOkHttpClient() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        mOkHttpClient = new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .readTimeout(120, TimeUnit.SECONDS)
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }

    @SuppressWarnings("unused")
    public void clearApiService() {
        mApiService = null;

        mOkHttpClient = null;
    }

    public ApiService getApiClient() {
        if (mApiService == null) {
            if (mRestAdapter == null){
                if (mOkHttpClient == null){
                    initOkHttpClient();
                }

                initRetrofit();
            }

            mApiService = mRestAdapter.create(ApiService.class);
        }

        return mApiService;
    }
}
