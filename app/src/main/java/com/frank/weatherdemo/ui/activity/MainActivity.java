package com.frank.weatherdemo.ui.activity;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;

import com.frank.weatherdemo.R;
import com.frank.weatherdemo.databinding.MainActivityBinding;
import com.frank.weatherdemo.ui.activity.base.BaseActivity;
import com.frank.weatherdemo.viewmodel.MainActivityViewModel;

public class MainActivity extends BaseActivity {
    private MainActivityViewModel mViewModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        @SuppressWarnings("RedundantTypeArguments")
        MainActivityBinding binding = DataBindingUtil.<MainActivityBinding>setContentView(this, R.layout.activity_main);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(this));
        mViewModel = new MainActivityViewModel(this);
        binding.setViewModel(mViewModel);
    }

    @Override
    protected void onResume() {
        super.onResume();

        if (mViewModel != null){
            mViewModel.refreshWeather();
        }
    }
}
