package com.example.weather.ui.base.custom;

import android.content.Context;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecyclerItemClickListener implements RecyclerView.OnItemTouchListener {

    private GestureDetector gestureDetector;
    private OnRecyclerViewItemClickListener recyclerViewItemClickListener;

    public RecyclerItemClickListener(Context context, OnRecyclerViewItemClickListener listener) {
        recyclerViewItemClickListener = listener;
        gestureDetector = new GestureDetector(context, new GestureDetector.SimpleOnGestureListener() {
            @Override
            public boolean onSingleTapUp(MotionEvent e) {
                return false;
            }
        });
    }

    @Override
    public boolean onInterceptTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
        View childView = rv.findChildViewUnder(e.getX(), e.getY());

        if (childView != null && recyclerViewItemClickListener != null && gestureDetector.onTouchEvent(e)) {
            recyclerViewItemClickListener.onItemClick(rv, childView, rv.getChildLayoutPosition(childView));
        }
        return false;
    }

    @Override
    public void onTouchEvent(@NonNull RecyclerView rv, @NonNull MotionEvent e) {
    }

    @Override
    public void onRequestDisallowInterceptTouchEvent(boolean disallowIntercept) {
    }

    public interface OnRecyclerViewItemClickListener {
        void onItemClick(View parentView, View childView, int position);
    }
}
