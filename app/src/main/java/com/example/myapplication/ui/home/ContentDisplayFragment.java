package com.example.myapplication.ui.home;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class ContentDisplayFragment extends Fragment {

    private static final String ARG_CONTENT = "content";
    private String content;

    public ContentDisplayFragment() {
        // Required empty public constructor
    }

    public static ContentDisplayFragment newInstance(String content) {
        ContentDisplayFragment fragment = new ContentDisplayFragment();
        Bundle args = new Bundle();
        args.putString(ARG_CONTENT, content);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            content = getArguments().getString(ARG_CONTENT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Create a dialog
        final Dialog dialog = new Dialog(getActivity());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);

        // Create a LinearLayout as the main container
        LinearLayout mainLayout = new LinearLayout(getActivity());
        mainLayout.setOrientation(LinearLayout.VERTICAL);
        mainLayout.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT));
        mainLayout.setPadding(20, 20, 20, 20);

        // Create a TextView for content
        TextView textView = new TextView(getActivity());
        textView.setText(content);
        mainLayout.addView(textView);

        // Create a Close button
        Button closeButton = new Button(getActivity());
        closeButton.setText("Close");
        closeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
            }
        });
        mainLayout.addView(closeButton);

        // Set the main layout as the content of the dialog
        dialog.setContentView(mainLayout);

        // Display the dialog
        dialog.show();

        // Return an empty view
        return new View(getActivity());
    }
}
