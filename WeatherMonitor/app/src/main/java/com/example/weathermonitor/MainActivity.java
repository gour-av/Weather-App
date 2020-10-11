package com.example.weathermonitor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class MainActivity extends AppCompatActivity {

    private Handler mhandler = new Handler();
    private Boolean IsFirst = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            mhandler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    dostuff();
                }
            }, 5000);
    }



    @Override
    protected void onRestart() {
        super.onRestart();
        mhandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                //dostuff();
            }
        }, 1000);

    }

    private void dostuff() {

        Bundle bundle = new Bundle();
        bundle.putString("city", "Banglore");
        bundle.putString("weoid", "220101");
        Intent intent = new Intent(MainActivity.this, SearchActivity.class);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}