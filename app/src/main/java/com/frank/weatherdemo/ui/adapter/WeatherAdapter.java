package com.frank.weatherdemo.ui.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.frank.weatherdemo.R;
import com.frank.weatherdemo.databinding.WeatherDescriptionBinding;
import com.frank.weatherdemo.databinding.WeatherForecastAllBinding;
import com.frank.weatherdemo.databinding.WeatherForecastTodayBinding;
import com.frank.weatherdemo.model.WeatherDescription;
import com.frank.weatherdemo.model.WeatherForecast;
import com.frank.weatherdemo.model.WeatherResult;
import com.frank.weatherdemo.net.response.WeatherGetResponse;
import com.frank.weatherdemo.ui.adapter.base.BaseViewHolder;
import com.frank.weatherdemo.viewmodel.WeatherDescriptionViewModel;
import com.frank.weatherdemo.viewmodel.WeatherForecastAllViewModel;
import com.frank.weatherdemo.viewmodel.WeatherForecastTodayViewModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by frank on 26/05/16.
 *
 */
public class WeatherAdapter extends RecyclerView.Adapter<BaseViewHolder> {
    private static final int VIEW_TYPE_WEATHER_FORECAST_TODAY = 0x1;
    private static final int VIEW_TYPE_WEATHER_FORECAST_ALL = VIEW_TYPE_WEATHER_FORECAST_TODAY + 1;
    private static final int VIEW_TYPE_WEATHER_FORECAST_DESCRIPTION = VIEW_TYPE_WEATHER_FORECAST_ALL + 1;
    private final ArrayList<WeatherUIDataBase> weatherUIDataBaseArrayList = new ArrayList<>();

    public WeatherAdapter() {

    }

    @SuppressWarnings("ConstantConditions")
    public void setData(WeatherGetResponse weatherGetResponse) {
        weatherUIDataBaseArrayList.clear();

        WeatherResult weatherResult = weatherGetResponse.getWeatherResult();
        if (weatherResult != null) {
            weatherUIDataBaseArrayList.add(new WeatherForecastTodayUIData(weatherResult));

            if (weatherResult.weatherForecastList != null) {
                weatherUIDataBaseArrayList.add(new WeatherForecastAllUIData(weatherResult.weatherForecastList));
            }

            if (weatherResult.weatherDescriptionList != null) {
                for (WeatherDescription weatherDescription : weatherResult.weatherDescriptionList) {
                    weatherUIDataBaseArrayList.add(new WeatherDescriptionUIData(weatherDescription));
                }
            }
        }

        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position) {
        switch (weatherUIDataBaseArrayList.get(position).uiDataType) {
            case EWeatherForecastToday:
                return VIEW_TYPE_WEATHER_FORECAST_TODAY;
            case EWeatherForecastAll:
                return VIEW_TYPE_WEATHER_FORECAST_ALL;
            case EWeatherDescription:
            default:
                return VIEW_TYPE_WEATHER_FORECAST_DESCRIPTION;
        }
    }

    @Override
    public BaseViewHolder<? extends WeatherUIDataBase<?>> onCreateViewHolder(ViewGroup parent, int viewType) {
        switch (viewType) {
            case VIEW_TYPE_WEATHER_FORECAST_TODAY: {
                View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_weather_forecast_today, parent, false);
                return new WeatherForecastTodayViewHolder(itemView);
            }
            case VIEW_TYPE_WEATHER_FORECAST_ALL: {
                View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_weather_forecast_all, parent, false);
                return new WeatherForecastAllViewHolder(itemView);
            }
            case VIEW_TYPE_WEATHER_FORECAST_DESCRIPTION:
            default: {
                View itemView = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.item_weather_description, parent, false);
                return new WeatherDescriptionViewHolder(itemView);
            }
        }
    }

    @SuppressWarnings("unchecked")
    @Override
    public void onBindViewHolder(BaseViewHolder holder, int position) {
        holder.bind(weatherUIDataBaseArrayList.get(position));
    }

    @Override
    public int getItemCount() {
        return weatherUIDataBaseArrayList.size();
    }

    public static abstract class WeatherUIDataBase<T> {
        final T data;
        private final TUIDataType uiDataType;

        WeatherUIDataBase(TUIDataType uiDataType, T data) {
            this.uiDataType = uiDataType;

            this.data = data;
        }

        public enum TUIDataType {
            EWeatherForecastToday,
            EWeatherForecastAll,
            EWeatherDescription
        }
    }

    public static class WeatherForecastTodayUIData extends WeatherUIDataBase<WeatherResult> {
        public WeatherForecastTodayUIData(WeatherResult weatherResult) {
            super(TUIDataType.EWeatherForecastToday, weatherResult);
        }
    }

    public static class WeatherForecastAllUIData extends WeatherUIDataBase<List<WeatherForecast>> {
        public WeatherForecastAllUIData(List<WeatherForecast> weatherForecastList) {
            super(TUIDataType.EWeatherForecastAll, weatherForecastList);
        }
    }

    public static class WeatherDescriptionUIData extends WeatherUIDataBase<WeatherDescription> {
        public WeatherDescriptionUIData(WeatherDescription weatherDescription) {
            super(TUIDataType.EWeatherDescription, weatherDescription);
        }
    }

    public class WeatherForecastTodayViewHolder extends BaseViewHolder<WeatherForecastTodayUIData> {
        private final WeatherForecastTodayBinding binding;

        public WeatherForecastTodayViewHolder(View itemView) {
            super(itemView);
            binding = WeatherForecastTodayBinding.bind(itemView);
        }

        public void bind(@NonNull WeatherForecastTodayUIData data) {
            binding.setViewModel(new WeatherForecastTodayViewModel(data.data));
        }
    }

    public class WeatherForecastAllViewHolder extends BaseViewHolder<WeatherForecastAllUIData> {
        private final WeatherForecastAllBinding binding;

        public WeatherForecastAllViewHolder(View itemView) {
            super(itemView);
            binding = WeatherForecastAllBinding.bind(itemView);
        }

        public void bind(@NonNull WeatherForecastAllUIData data) {
            binding.setViewModel(new WeatherForecastAllViewModel(data.data));
        }
    }

    public class WeatherDescriptionViewHolder extends BaseViewHolder<WeatherDescriptionUIData> {
        private final WeatherDescriptionBinding binding;

        public WeatherDescriptionViewHolder(View itemView) {
            super(itemView);
            binding = WeatherDescriptionBinding.bind(itemView);
        }

        public void bind(@NonNull WeatherDescriptionUIData data) {
            binding.setViewModel(new WeatherDescriptionViewModel(data.data));
        }
    }
}
