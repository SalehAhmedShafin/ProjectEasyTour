package com.example.easytour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

public class SplashActivity extends AppCompatActivity {

    private static int SPLASH_SCREEN =4000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        new Handler().postDelayed(new Runnable() {
            @Override


            public void run() {
                Intent intent=new Intent(SplashActivity.this,SignupInActivity.class);
                startActivity(intent);
                finish();
            }
        },SPLASH_SCREEN);

    }
}