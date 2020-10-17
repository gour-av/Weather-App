package com.example.weathermonitor;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {

    private TextView tv_appName;
    private final Handler mhandler = new Handler();
    private final int delay = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv_appName = findViewById(R.id.tv_appName);
        animation();
        mhandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                dostuff();
            }
        }, delay);

    }

    private void dostuff() {

        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
        startActivity(intent);
        finish();
    }

    private void animation() {

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate);
        tv_appName.startAnimation(animation);
    }

}