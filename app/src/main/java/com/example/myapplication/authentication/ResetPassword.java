package com.example.myapplication.authentication;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.myapplication.R;
import com.google.firebase.auth.FirebaseAuth;

public class ResetPassword extends AppCompatActivity {

    private FirebaseAuth auth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getSupportActionBar() != null) {
            getSupportActionBar().hide();
        }
        setContentView(R.layout.activity_reset_password);

        // Initialize Firebase Auth
        auth = FirebaseAuth.getInstance();

        // Initialize views
        EditText editTextEmail = findViewById(R.id.editTextEmail);
        EditText editTextNewPassword = findViewById(R.id.editTextNewPassword);
        EditText editTextConfirmNewPassword = findViewById(R.id.editTextConfirmNewPassword);
        Button buttonResetPassword = findViewById(R.id.buttonResetPassword);
        Button buttonGoToSignIn = findViewById(R.id.buttonGoToSignIn);

        // Set up button click listeners
        buttonResetPassword.setOnClickListener(v -> {
            String email = editTextEmail.getText().toString().trim();
            String newPassword = editTextNewPassword.getText().toString().trim();
            String confirmNewPassword = editTextConfirmNewPassword.getText().toString().trim();

            // Validate input
            if (email.isEmpty() || newPassword.isEmpty() || confirmNewPassword.isEmpty()) {
                Toast.makeText(ResetPassword.this, "Please fill all fields", Toast.LENGTH_SHORT).show();
                return;
            }

            if (!newPassword.equals(confirmNewPassword)) {
                Toast.makeText(ResetPassword.this, "Passwords do not match", Toast.LENGTH_SHORT).show();
                return;
            }

            // Reset password logic (Firebase)
            // Note: Firebase Auth does not directly allow setting a new password through the app.
            // Usually, a password reset email is sent to the user.
            auth.sendPasswordResetEmail(email)
                    .addOnCompleteListener(task -> {
                        if (task.isSuccessful()) {
                            Toast.makeText(ResetPassword.this, "Password reset email sent", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(ResetPassword.this, "Failed to send reset email", Toast.LENGTH_SHORT).show();
                        }
                    });
        });

        buttonGoToSignIn.setOnClickListener(v -> {
            Intent intent = new Intent(this, MainActivity.class);
            startActivity(intent);
        });
    }
}
