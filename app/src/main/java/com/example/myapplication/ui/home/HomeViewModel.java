package com.example.myapplication.ui.home;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel {

    private final MutableLiveData<List<String>> options;

    public HomeViewModel() {
        options = new MutableLiveData<>();
        // Initialize with default options
        List<String> defaultOptions = new ArrayList<>();
        defaultOptions.add("Learn Java");
        defaultOptions.add("Learn Python");
        defaultOptions.add("Track Progress");
        defaultOptions.add("Open Chat Bot");
        options.setValue(defaultOptions);
    }

    public LiveData<List<String>> getOptions() {
        return options;
    }
}
