package com.example.se_5.app;

import android.content.Context;
import android.nfc.Tag;
import android.util.Log;
import android.widget.Toast;

public class app {

    public static class main{
        public static final String Tag = "SE_5";
    }

    public static void l(String message){
        Log.e(main.Tag, message);
    }

    public static void t(String message){
        Toast.makeText(Application.getContext(), message, Toast.LENGTH_SHORT).show();
    }
}
