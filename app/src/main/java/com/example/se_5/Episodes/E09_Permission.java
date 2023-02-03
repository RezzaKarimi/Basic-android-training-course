package com.example.se_5.Episodes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.os.ResultReceiver;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.se_5.R;
import com.example.se_5.app.app;

public class E09_Permission extends AppCompatActivity {


    Button check;
    TextView state;
    final static int REQUEST_CODE = 306;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e09__permission);
        setTitle(getClass().getSimpleName());

        init();
    }

    private void init() {
       check = findViewById(R.id.check);
       state = findViewById(R.id.state);



       check.setOnClickListener(new View.OnClickListener() {
           @Override
           public void onClick(View v) {

               if (checkPermission()){

                   Action();
               }
           }
       });
    }

    private void Action(){
        state.setText(R.string.Granted);
    }


    private boolean checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1){

            if (ContextCompat.checkSelfPermission(this , Manifest.permission.SEND_SMS) == PackageManager.PERMISSION_GRANTED ){
                app.t("Android Version is: "+Build.VERSION.SDK_INT);
                return true;
            }
            else {

                ActivityCompat.requestPermissions(this , new String[]{Manifest.permission.SEND_SMS} , REQUEST_CODE );
            }

        }
        else {
            app.t("Android Version is: "+Build.VERSION.SDK_INT);
            return true;
        }
        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode){

            case REQUEST_CODE: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    Action();
                }

                else{
                    state.setText(R.string.Declined);
                }
                break;
            }

            default: super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }

    }
}