package com.example.weather.ui.main.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.weather.BuildConfig;
import com.example.weather.R;
import com.example.weather.data.local.entity.CityEntity;
import com.example.weather.databinding.MainActivityBinding;
import com.example.weather.ui.city.activity.AddCityActivity;
import com.example.weather.ui.detail.activity.WeatherDetailActivity;
import com.example.weather.ui.main.adapter.CitiesListAdapter.OnItemClickListener;
import com.example.weather.ui.main.adapter.CitiesListAdapter;
import com.example.weather.ui.main.viewmodel.CityListViewModel;
import com.example.weather.utils.ToastUtil;

import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, OnItemClickListener {

    private MainActivityBinding binding;

    CityListViewModel cityListViewModel;
    List<CityEntity> cityEntityList;

    public static final int REQUEST_CODE__ADD_CITY_ACTIVITY = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initialiseViewModel();
    }

    private void initialiseViewModel() {
        RecyclerView recyclerView = binding.recyclerview;
        CitiesListAdapter adapter = new CitiesListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        cityListViewModel = new ViewModelProvider(this).get(CityListViewModel.class);
        cityListViewModel.getCities().observe(this, cities -> {
            cityEntityList = cities;
            adapter.setCities(cities);
        });
        binding.ivAdd.setOnClickListener(this);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, AddCityActivity.class);
        startActivityForResult(intent, REQUEST_CODE__ADD_CITY_ACTIVITY);
    }

    public void onItemClick(int position, View view) {
        switch (view.getId()) {
            case R.id.ivDelete:
                CityEntity cityEntity = cityEntityList.get(position);
                cityListViewModel.deleteCity(cityEntity);
                break;
            case R.id.constraintLayout:
                Intent intent = new Intent(this, WeatherDetailActivity.class);
                intent.putExtra(BuildConfig.INTENT_CITY, cityEntityList.get(position).getName());
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE__ADD_CITY_ACTIVITY) {
            CityEntity city = new CityEntity(data.getStringExtra(BuildConfig.INTENT_CITY));
            cityListViewModel.insertCity(city);
        } else {
            ToastUtil.showLong(this, R.string.empty_city_name);
        }
    }

}