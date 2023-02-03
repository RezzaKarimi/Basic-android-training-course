package com.example.se_5.Episodes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

import com.example.se_5.R;
import com.example.se_5.app.app;

public class E20_BackPressed extends AppCompatActivity {

    Boolean firstTime = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e20__back_pressed);
    }

    @Override
    public void onBackPressed() {

        if (firstTime){

            firstTime = false;
            app.t("Press back again for Exit");

            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    firstTime = true;
                }
            },1000);

        }else {
            super.onBackPressed();
        }


    }
}