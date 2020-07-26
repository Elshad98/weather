package com.example.weather.ui.main.adapter;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.weather.data.local.entity.CityEntity;
import com.example.weather.databinding.CitiesListItemBinding;

import java.util.ArrayList;
import java.util.List;

public class CitiesListAdapter extends RecyclerView.Adapter<CitiesListAdapter.CustomViewHolder> {

    private Activity activity;
    private List<CityEntity> cities;

    public CitiesListAdapter(Activity activity) {
        this.activity = activity;
        this.cities = new ArrayList<>();
    }

    @NonNull
    @Override
    public CitiesListAdapter.CustomViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        CitiesListItemBinding itemBinding = CitiesListItemBinding.inflate(layoutInflater, parent, false);
        return new CustomViewHolder(itemBinding);
    }

    public void setItems(List<CityEntity> cities) {
        int startPosition = this.cities.size();
        this.cities.addAll(cities);
        notifyItemRangeChanged(startPosition, cities.size());
    }

    @Override
    public int getItemCount() {
        return cities.size();
    }

    public CityEntity getItem(int position) {
        return cities.get(position);
    }

    public void onBindViewHolder(CitiesListAdapter.CustomViewHolder holder, int position) {
        holder.bindTo(getItem(position));
    }

    static class CustomViewHolder extends RecyclerView.ViewHolder {
        final CitiesListItemBinding binding;

        public CustomViewHolder(CitiesListItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }

        public void bindTo(CityEntity city) {
            binding.textView.setText(city.getName());
        }
    }
}
