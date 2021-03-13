package com.github.apppetr.doshatest.RateUs;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.github.apppetr.doshatest.R;

public class LoveOurAppRateActivity extends AppCompatActivity {

    String appPackageName;
    ImageView rateUs;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.love_our_app_rate);
        Bundle extras = getIntent().getExtras();
        rateUs = (ImageView) findViewById(R.id.star1);
        appPackageName = extras.getString("appPackageName");

        rateUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                rate(appPackageName);
            }
        });
    }

    public void rate(String appPackageName){
        String url = "market://details?id=" + appPackageName;

        try {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
        } catch (android.content.ActivityNotFoundException anfe) {
            startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://play.google.com/store/apps/details?id=" + appPackageName)));
        }
        LoveOurAppRate.setOptOut(this, true);
    }
}
