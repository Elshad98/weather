package com.example.weather.ui.main.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather.App;
import com.example.weather.R;
import com.example.weather.data.local.entity.CityEntity;
import com.example.weather.databinding.MainActivityBinding;
import com.example.weather.ui.base.BaseActivity;
import com.example.weather.ui.city.activity.AddCityActivity;
import com.example.weather.ui.detail.activity.WeatherDetailActivity;
import com.example.weather.ui.main.adapter.CitiesListAdapter;
import com.example.weather.ui.main.adapter.CitiesListAdapter.OnItemClickListener;
import com.example.weather.ui.main.viewmodel.CityListViewModel;
import com.example.weather.utils.ToastUtil;

import java.util.List;

public class MainActivity extends BaseActivity implements View.OnClickListener, OnItemClickListener {

    public static final String EXTRA_CITY = "city";
    public static final int REQUEST_CODE_ADD_CITY_ACTIVITY = 1;

    private CitiesListAdapter adapter;
    private CityListViewModel viewModel;
    private MainActivityBinding binding;
    private List<CityEntity> cityEntityList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main);

        RecyclerView recyclerView = binding.recyclerview;
        adapter = new CitiesListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        viewModel = viewModel(CityListViewModel.class, App.scope());
        viewModel.loadFromDb();
        viewModel.getCities().observe(this, this::onSuccess);
        binding.ivAdd.setOnClickListener(this);
    }

    private void onSuccess(List<CityEntity> cities) {
        cityEntityList = cities;
        adapter.setCities(cities);
    }

    public void onClick(View view) {
        Intent intent = new Intent(this, AddCityActivity.class);
        startActivityForResult(intent, REQUEST_CODE_ADD_CITY_ACTIVITY);
    }

    public void onItemClick(int position, View view) {
        switch (view.getId()) {
            case R.id.ivDelete:
                CityEntity cityEntity = cityEntityList.get(position);
                viewModel.deleteCity(cityEntity);
                break;
            case R.id.constraintLayout:
                Intent intent = new Intent(this, WeatherDetailActivity.class);
                intent.putExtra(EXTRA_CITY, cityEntityList.get(position).getName());
                startActivity(intent);
                break;
        }
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (resultCode == RESULT_OK && requestCode == REQUEST_CODE_ADD_CITY_ACTIVITY) {
            CityEntity city = new CityEntity(data.getStringExtra(EXTRA_CITY));
            viewModel.insertCity(city);
        } else {
            ToastUtil.showLong(R.string.empty_city_name);
        }
    }
}