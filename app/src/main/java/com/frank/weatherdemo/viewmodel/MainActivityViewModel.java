package com.frank.weatherdemo.viewmodel;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.view.View;

import com.frank.weatherdemo.R;
import com.frank.weatherdemo.manager.BaiDuWeatherManager;
import com.frank.weatherdemo.net.response.WeatherGetResponse;
import com.frank.weatherdemo.ui.activity.base.BaseActivity;
import com.frank.weatherdemo.ui.adapter.WeatherAdapter;
import com.frank.weatherdemo.ui.fragment.ProgressDialog;
import com.frank.weatherdemo.utils.Utils;
import com.trello.rxlifecycle.ActivityEvent;

import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;

/**
 * Created by frank on 26/05/16.
 *
 */
public class MainActivityViewModel {
    public final ObservableBoolean mShowRefresh = new ObservableBoolean(true);
    public final ObservableBoolean mShowLoading = new ObservableBoolean(false);
    public final ObservableField<WeatherAdapter> mWeatherAdapter = new ObservableField<>();
    private final BaseActivity mActivity;
    private final WeatherAdapter mAdapter;

    public MainActivityViewModel(BaseActivity activity) {
        mActivity = activity;
        mAdapter = new WeatherAdapter();
    }

    @SuppressWarnings("unused")
    public View.OnClickListener onRefreshClick(){
        return new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                refreshWeather();
            }
        };
    }

    public void refreshWeather() {
        BaiDuWeatherManager.getInstance().weatherGet("杭州")
                .observeOn(AndroidSchedulers.mainThread())
                .compose(mActivity.<WeatherGetResponse>bindUntilEvent(ActivityEvent.PAUSE))
                .doOnSubscribe(new Action0() {
                    @Override
                    public void call() {
                        showProgress(true);

                    }
                })
                .subscribe(new Action1<WeatherGetResponse>() {
                               @Override
                               public void call(WeatherGetResponse weatherGetResponse) {
                                   if (weatherGetResponse.isOK()) {
                                       mAdapter.setData(weatherGetResponse);
                                       mWeatherAdapter.set(mAdapter);
                                   } else {
                                       Utils.snack(mActivity, weatherGetResponse.getError());
                                   }

                                   showProgress(false);
                               }
                           },
                        new Action1<Throwable>() {
                            @Override
                            public void call(Throwable throwable) {
                                Utils.snack(mActivity, throwable.getMessage());
                                showProgress(false);
                            }
                        });
    }

    private void showProgress(boolean isShow) {
        mShowLoading.set(isShow);
        mShowRefresh.set(!isShow);

        if (isShow){
            ProgressDialog.display(mActivity, R.string.common_blocking_please_wait);
        }else{
            ProgressDialog.dismiss(mActivity);
        }
    }
}
