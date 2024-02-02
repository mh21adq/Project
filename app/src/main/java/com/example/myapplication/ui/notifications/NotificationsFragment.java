package com.example.myapplication.ui.notifications;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.myapplication.R;
import com.example.myapplication.ChatBot.ChatActivity;

public class NotificationsFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notifications, container, false);

        // Assuming your button's ID is openAIChatBotButton as per the updated layout
        Button openAIChatBotButton = view.findViewById(R.id.openAIChatBotButton);

        openAIChatBotButton.setOnClickListener(v -> {
            // Start ChatActivity when the button is clicked
            Intent intent = new Intent(getActivity(), ChatActivity.class);
            startActivity(intent);
        });

        return view;
    }
}
