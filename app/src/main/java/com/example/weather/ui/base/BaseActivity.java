package com.example.weather.ui.base;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.example.weather.factory.ToothpickFactory;

import toothpick.Scope;

public class BaseActivity extends AppCompatActivity {

    protected final <T extends ViewModel> T viewModel(Class<T> viewModelClass, Scope scope) {
        return new ViewModelProvider(this, new ToothpickFactory(scope))
                .get(viewModelClass);
    }
}