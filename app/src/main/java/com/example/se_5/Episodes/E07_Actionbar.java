package com.example.se_5.Episodes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import com.example.se_5.R;
import com.example.se_5.app.app;

import java.util.zip.Inflater;

public class E07_Actionbar extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e07__actionbar);
        setTitle(getClass().getSimpleName());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater= getMenuInflater();
        menuInflater.inflate(R.menu.e07_actionbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()){

            case R.id.Settings:
                app.t("Settings is Clicked");
                break;

            case R.id.Contacts:
                app.t("Contacts is Clicked");
                break;

            case R.id.Status:
                app.t("Status is Clicked");
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}