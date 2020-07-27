package com.example.weather.ui.main.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import androidx.recyclerview.widget.RecyclerView.Adapter;

import com.example.weather.data.local.entity.CityEntity;
import com.example.weather.databinding.CitiesListItemBinding;

import java.util.List;

public class CitiesListAdapter extends Adapter<CitiesListAdapter.CustomViewHolder> {

    private List<CityEntity> cities;
    private OnItemClickListener listener;

    public CitiesListAdapter(OnItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        CitiesListItemBinding itemBinding = CitiesListItemBinding.inflate(inflater, parent, false);
        return new CustomViewHolder(itemBinding, listener);
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder holder, int position) {
        if (cities != null) {
            CityEntity current = cities.get(position);
            holder.binding.tvCityName.setText(current.getName());
        }
    }

    @Override
    public int getItemCount() {
        if (cities != null) {
            return cities.size();
        }
        return 0;
    }

    public void setCities(List<CityEntity> cities) {
        this.cities = cities;
        notifyDataSetChanged();
    }

    protected static class CustomViewHolder extends ViewHolder implements View.OnClickListener {
        final CitiesListItemBinding binding;
        private OnItemClickListener listener;

        public CustomViewHolder(@NonNull CitiesListItemBinding binding, OnItemClickListener listener) {
            super(binding.getRoot());
            this.binding = binding;
            this.listener = listener;
            this.binding.ivDelete.setOnClickListener(this);
            this.binding.constraintLayout.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            if (position != RecyclerView.NO_POSITION) {
                listener.onItemClick(position, view);
            }
        }
    }

    public interface OnItemClickListener {
        void onItemClick(int position, View view);
    }
}
