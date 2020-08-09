package com.example.weather.ui.city.activity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import com.example.weather.R;
import com.example.weather.databinding.AddCityActivityBinding;
import com.example.weather.utils.Constants;

public class AddCityActivity extends AppCompatActivity {

    private AddCityActivityBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_city);
        binding.btnAdd.setOnClickListener(this::onClick);
    }

    public void onClick(View view) {
        String cityName = binding.etCityName.getText().toString();
        if (!TextUtils.isEmpty(cityName)) {
            setResult(RESULT_OK, new Intent().putExtra(Constants.INTENT_CITY, cityName));
            finish();
        }
    }
}
