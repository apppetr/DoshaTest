package com.github.apppetr.doshatest;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;

public class StartActivity extends Activity {

    ImageView imageView;
    TextView textView;
    TextView textViewGood;
    int count = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_start);
        imageView = findViewById(R.id.imageView);
        textView = findViewById(R.id.textView);
        textViewGood = findViewById(R.id.textViewgood);
        imageView.setOnTouchListener(new OnSwipeTouchListener(getApplicationContext()) {
            public void onSwipeTop() {
            }

            public void onSwipeRight() {
                if (count == 0) {
                    imageView.setImageResource(R.drawable.good_night_img);
                    textView.setText("Ночи");
                    textViewGood.setText("Доброй ");
                    count = 1;
                } else {
                    imageView.setImageResource(R.drawable.good_morning_img);
                    textViewGood.setText("Доброе ");
                    textView.setText("Утро");
                    count = 0;
                }
            }

            public void onSwipeLeft() {
                if (count == 0) {
                    imageView.setImageResource(R.drawable.good_night_img);
                    textView.setText("Ночи");
                    textViewGood.setText("Доброй ");
                    count = 1;
                } else {
                    imageView.setImageResource(R.drawable.good_morning_img);
                    textViewGood.setText("Доброе ");
                    textView.setText("Утро");
                    count = 0;
                }
            }

            public void onSwipeBottom() {
            }

        });

        TextView modelTextview = (TextView) findViewById(R.id.showDocs);
        modelTextview.setOnClickListener(v -> {
            Intent i = new Intent(StartActivity.this, MainActivity.class);
            startActivity(i);
            finish();
        });
    }



}