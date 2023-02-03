package com.example.se_5.Episodes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.Manifest;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.animation.AnimationUtils;
import android.view.animation.LayoutAnimationController;

import com.example.se_5.Adaptor.E10Adapter;
import com.example.se_5.Objects.E10object;
import com.example.se_5.R;
import com.example.se_5.app.app;
import com.example.se_5.fragment.E10Fragment;

import java.util.ArrayList;
import java.util.List;


public class E10_Contacts extends AppCompatActivity {


    final static int REQUEST_CODE = 101;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e10__contacts);

        setTitle(getClass().getSimpleName());
        init();
    }

    public void init() {


        if (checkPermission()){
            E10Fragment.permissionListener.onPermissionCheck(true);
        }
    }


    private boolean checkPermission() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP_MR1){

            if (ContextCompat.checkSelfPermission(this , Manifest.permission.READ_CONTACTS) == PackageManager.PERMISSION_GRANTED ){

                return true;
            }
            else {

                ActivityCompat.requestPermissions(this , new String[]{Manifest.permission.READ_CONTACTS} , REQUEST_CODE );
            }

        }
        else {

            return true;
        }
        return false;
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {

        switch (requestCode){

            case REQUEST_CODE: {
                if (grantResults[0] == PackageManager.PERMISSION_GRANTED){
                    E10Fragment.permissionListener.onPermissionCheck(true);
                }

                else{
                    init();
                    app.t(getString(R.string.Declined));
                }
                break;
            }

            default: super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }

    }


}