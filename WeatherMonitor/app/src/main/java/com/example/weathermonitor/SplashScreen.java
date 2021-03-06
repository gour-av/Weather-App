package com.example.weathermonitor;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SplashScreen extends AppCompatActivity {

    private final Handler mhandler = new Handler();
    private final int delay = 5000;
    private TextView tv_appName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

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

        Intent intent = new Intent(SplashScreen.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    private void animation() {

        Animation animation = AnimationUtils.loadAnimation(this, R.anim.translate);
        tv_appName.startAnimation(animation);
    }
}