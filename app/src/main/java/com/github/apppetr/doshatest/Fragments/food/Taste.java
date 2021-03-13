package com.github.apppetr.doshatest.Fragments.food;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import androidx.fragment.app.Fragment;
import androidx.preference.PreferenceManager;

import com.github.apppetr.doshatest.MainActivity;
import com.github.apppetr.doshatest.R;

public class Taste extends Fragment {
    WebView webview;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view;
        view = inflater.inflate(R.layout.fragment_web_view, container, false);
        webview = view.findViewById(R.id.webView);
        webview.loadUrl("file:///android_asset/html/taste.html");
        return view;
    }

}
