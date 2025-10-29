package com.example.travelhub.Splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import androidx.appcompat.app.AppCompatActivity;

import com.example.travelhub.MainActivity;
import com.example.travelhub.R;
import com.example.travelhub.Slider.SliderActivity;

public class SplashScreen extends AppCompatActivity {

    Handler handler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                boolean IsFirstUse = getSharedPreferences("FirstLogin", MODE_PRIVATE).getBoolean("FirstUse", true);
                if (!IsFirstUse) {
                    startActivity(new Intent(SplashScreen.this, MainActivity.class));
                    finish();
                }else {
                    startActivity(new Intent(SplashScreen.this, SliderActivity.class));
                    finish();
                }
            }
        }, 3000);
    }
}