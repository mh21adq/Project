package com.example.myapplication.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.myapplication.R;

public class DashboardFragment extends Fragment {

    private EditText codeEditor;
    private TextView outputText;
    private TextView problemDescription;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        // Initialize the UI components
        codeEditor = view.findViewById(R.id.codeEditor);
        Button runCodeButton = view.findViewById(R.id.runCodeButton);
        outputText = view.findViewById(R.id.outputText); // Make sure you have a TextView with this ID in your XML
        problemDescription = view.findViewById(R.id.problemDescription);

        // Set a problem description (you can modify this text)
        problemDescription.setText("Sample Problem: Write a Java method to add two numbers.");

        // Set the onClickListener for the run button
        runCodeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // When the button is clicked, display the code in the outputText
                String code = codeEditor.getText().toString();
                outputText.setText(code); // Display the code in the output TextView
            }
        });
        return view;
    }
}
