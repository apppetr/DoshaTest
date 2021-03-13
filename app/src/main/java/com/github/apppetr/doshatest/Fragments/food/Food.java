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
import java.util.Arrays;

public class Food extends Fragment {
    WebView webview;

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        final SharedPreferences shared = PreferenceManager.getDefaultSharedPreferences(super.getContext());
        int vata_result = shared.getInt(MainActivity.PREFERENCE_RESULT_VATA, MainActivity.PREFERENCE_RESULT_VATA_DEFAULT);
        int pitta_result = shared.getInt(MainActivity.PREFERENCE_RESULT_PITTA, MainActivity.PREFERENCE_RESULT_PITTA_DEFAULT);
        int kapha_result = shared.getInt(MainActivity.PREFERENCE_RESULT_KAPHA, MainActivity.PREFERENCE_RESULT_KAPHA_DEFAULT);
        View view;
        view = inflater.inflate(R.layout.fragment_web_view, container, false);
        webview = view.findViewById(R.id.webView);
        String prakrity = "";
        int[] resultArray =
                new int[]{vata_result, pitta_result, kapha_result};
        Arrays.sort(resultArray);

        if (resultArray[2] == vata_result) {
            prakrity = "html/vata_balance.html";
        } else if (resultArray[2] == pitta_result) {
            prakrity = "html/pitta_balance.html";

        } else if (resultArray[2] == kapha_result) {
            prakrity = "html/kapha_balance.html";
        }
        webview.loadUrl("file:///android_asset/" + prakrity);
        return view;
    }

}
