package com.example.bhagyesh.hairdonationapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.os.Handler;

import com.example.bhagyesh.hairdonationapp.Utility.StorageBox;


public class SplashScreen extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_fullscreen);

        final Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {


                if (!new StorageBox<Boolean>().getResultData(SplashScreen.this, "isLogin")) {
                    startActivity(new Intent(SplashScreen.this, LoginActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(SplashScreen.this, HomeActivity.class));
                    finish();
                }
            }
        }, 2000);
    }


}
