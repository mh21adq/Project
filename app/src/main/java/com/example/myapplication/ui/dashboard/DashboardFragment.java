package com.example.myapplication.ui.dashboard;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.fragment.app.Fragment;
import com.example.myapplication.R;
public class DashboardFragment extends Fragment {

    private WebView javaCompilerWebView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);

        javaCompilerWebView = view.findViewById(R.id.javaCompilerWebView);
        initializeWebView();

        return view;
    }

    private void initializeWebView() {
        WebSettings webSettings = javaCompilerWebView.getSettings();
        webSettings.setJavaScriptEnabled(true);
        webSettings.setDomStorageEnabled(true);

        javaCompilerWebView.loadUrl("https://www.online-java.com/");

        javaCompilerWebView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                // Hide elements by their CSS selectors
                // Example: "#header", ".ads", etc.
                // This is a basic example and may not work with all websites.
                view.loadUrl("javascript:(function() { " +
                        "document.querySelector('#header').style.display='none'; " +
                        "document.querySelector('#footer').style.display='none'; " +
                        "})()");
            }
        });
    }
}
