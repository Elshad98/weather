package com.example.weather.ui.base.custom;

import androidx.recyclerview.widget.RecyclerView;

public abstract class RecyclerViewPaginator extends RecyclerView.OnScrollListener {

    private RecyclerView recyclerView;

    public RecyclerViewPaginator(RecyclerView recyclerView) {
        this.recyclerView = recyclerView;
        init();
    }

    private void init() {
        recyclerView.addOnScrollListener(this);
        loadFirstData();
    }

    public abstract void loadFirstData();

    public abstract void loadMore();
}
