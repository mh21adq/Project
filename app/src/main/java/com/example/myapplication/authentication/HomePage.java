package com.example.myapplication.authentication;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;
import com.google.firebase.auth.FirebaseAuth;
import android.widget.*;
import android.widget.Toast;

public class HomePage extends AppCompatActivity {

    private Button buttonLogout,buttonLearn;
    private FirebaseAuth firebaseAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        // Initialize Firebase Auth
        firebaseAuth = FirebaseAuth.getInstance();

        // Set up the Logout button
        buttonLogout = findViewById(R.id.buttonLogout);
        buttonLearn=findViewById(R.id.buttonStartLearning);
        buttonLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Sign the user out
                firebaseAuth.signOut();

                // Redirect to MainActivity
                Intent intent = new Intent(HomePage.this, MainActivity.class);
                startActivity(intent);
                finish(); // Finish the current activity
            }
        });
        buttonLearn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showToast("Hi");
            }
        });
    }

    private void showToast(String message) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
    }
}
