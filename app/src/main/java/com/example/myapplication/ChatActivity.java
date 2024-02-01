package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ChatActivity extends AppCompatActivity {

    private static final String TAG = "ChatActivity";
    private EditText userMessageEditText;
    private TextView responseTextView;
    private final String apiKey = "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"; // Replace with your actual API key

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chat);

        userMessageEditText = findViewById(R.id.userMessageEditText);
        Button sendMessageButton = findViewById(R.id.sendMessageButton);
        responseTextView = findViewById(R.id.responseTextView);

        sendMessageButton.setOnClickListener(view -> {
            String userMessage = userMessageEditText.getText().toString().trim();
            if (!userMessage.isEmpty()) {
                callOpenAIAPi(userMessage);
                userMessageEditText.setText("");
            }
        });
    }

    private void callOpenAIAPi(String message) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.openai.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        OpenAIService service = retrofit.create(OpenAIService.class);

        List<OpenAIRequest.Message> messages = new ArrayList<>();
        messages.add(new OpenAIRequest.Message("user", message));

        OpenAIRequest request = new OpenAIRequest("gpt-4", messages);

        Call<OpenAIResponse> call = service.createChatCompletion("Bearer " + apiKey, request);

        call.enqueue(new Callback<OpenAIResponse>() {
            @Override
            public void onResponse(Call<OpenAIResponse> call, Response<OpenAIResponse> response) {
                if (response.isSuccessful() && response.body() != null && !response.body().getChoices().isEmpty()) {
                    String aiResponse = response.body().getChoices().get(0).getMessage().getContent();
                    responseTextView.append("\nAI: " + aiResponse);
                } else {
                    responseTextView.append("\nFailed to get a response from OpenAI.");
                    Log.e(TAG, "Response not successful or no content found");
                }
            }

            @Override
            public void onFailure(Call<OpenAIResponse> call, Throwable t) {
                responseTextView.append("\nAPI call failed: " + t.getMessage());
                Log.e(TAG, "API call failed: " + t.getMessage(), t);
            }
        });
    }
}
