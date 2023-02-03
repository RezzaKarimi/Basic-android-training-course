package com.example.se_5.Episodes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.MediaController;

import com.example.se_5.R;

public class SplashScreen extends AppCompatActivity {

    LinearLayout splash;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        splash = findViewById(R.id.splash);
        MediaPlayer mp = MediaPlayer.create(this , R.raw.piano);
        mp.start();
        splash.startAnimation(AnimationUtils.loadAnimation(this , R.anim.splash));

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(SplashScreen.this , E21_FinalActivity.class));
            }
        }, 3500);

    }
}