package com.example.weather.ui.main.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;
import androidx.core.app.ActivityOptionsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.weather.R;
import com.example.weather.data.local.entity.CityEntity;
import com.example.weather.databinding.CitiesListFragmentBinding;
import com.example.weather.factory.ViewModelFactory;
import com.example.weather.ui.base.BaseFragment;
import com.example.weather.ui.base.custom.RecyclerItemClickListener;
import com.example.weather.ui.base.custom.RecyclerViewPaginator;
import com.example.weather.ui.main.adapter.CitiesListAdapter;
import com.example.weather.ui.main.viewmodel.CityListViewModel;
import com.example.weather.utils.NavigationUtils;

import java.util.List;

import javax.inject.Inject;

public class CityListFragment extends BaseFragment implements RecyclerItemClickListener.OnRecyclerViewItemClickListener {
    @Inject
    ViewModelFactory viewModelFactory;

    CityListViewModel cityListViewModel;
    private CitiesListAdapter citiesListAdapter;
    private CitiesListFragmentBinding binding;

    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        initialiseViewModel();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle saveInstanceState) {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_cities_list, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initialiseView();
    }

    private void initialiseView() {
        citiesListAdapter = new CitiesListAdapter(activity);
        binding.citiesList.setLayoutManager(new LinearLayoutManager(activity, LinearLayoutManager.VERTICAL, false));
        binding.citiesList.setAdapter(citiesListAdapter);
        binding.citiesList.addOnItemTouchListener(new RecyclerItemClickListener(getContext(), this));

        binding.citiesList.addOnScrollListener(new RecyclerViewPaginator(binding.citiesList) {
            @Override
            public void loadMore() {
                cityListViewModel.loadCities();
            }

            @Override
            public void loadFirstData() {
                cityListViewModel.loadCities();
            }
        });
    }

    private void initialiseViewModel() {
        cityListViewModel = new ViewModelProvider(this, viewModelFactory).get(CityListViewModel.class);

        cityListViewModel.getCities().observe(this, resource -> {
            if (!resource.isEmpty()) {
                updateCitiesList(resource);
            }
        });
    }

    private void updateCitiesList(List<CityEntity> cities) {
        binding.citiesList.setVisibility(View.VISIBLE);
        citiesListAdapter.setItems(cities);
    }

    @Override
    public void onItemClick(View parentView, View childView, int position) {
        cityListViewModel.onStop();
        ActivityOptionsCompat options = ActivityOptionsCompat.makeSceneTransitionAnimation(activity,
                childView, "");
        NavigationUtils.redirectToDetailScreen(requireActivity(), citiesListAdapter.getItem(position), options);
    }
}
