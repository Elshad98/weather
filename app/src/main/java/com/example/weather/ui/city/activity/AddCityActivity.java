package com.example.weather.ui.city.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;

import androidx.databinding.DataBindingUtil;

import com.example.weather.R;
import com.example.weather.databinding.AddCityActivityBinding;
import com.example.weather.ui.base.BaseActivity;
import com.example.weather.ui.main.activity.MainActivity;
import com.example.weather.utils.ToastUtil;

public class AddCityActivity extends BaseActivity {

    private AddCityActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_city);
        binding.btnAdd.setOnClickListener(this::onClick);
    }

    public void onClick(View view) {
        String cityName = binding.etCityName.getText().toString().trim();
        if (!TextUtils.isEmpty(cityName)) {
            setResult(RESULT_OK, new Intent().putExtra(MainActivity.EXTRA_CITY, cityName));
            finish();
        } else {
            ToastUtil.showShort(R.string.input_city_name);
        }
    }
}
