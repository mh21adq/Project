package com.example.myapplication.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import com.example.myapplication.R;


public class HomeFragment extends Fragment {

    private ListView listView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View root = inflater.inflate(R.layout.fragment_home, container, false);

        // Initialize the ListView
        listView = root.findViewById(R.id.listView);

        // Get the ViewModel
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);

        // Observe the options list from the ViewModel and update the ListView
        homeViewModel.getOptions().observe(getViewLifecycleOwner(), options -> {
            ArrayAdapter<String> adapter = new ArrayAdapter<>(getContext(), android.R.layout.simple_list_item_1, options);
            listView.setAdapter(adapter);
        });

        return root;
    }
}
