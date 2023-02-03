package com.example.se_5.app;

import android.content.Context;

public class Application extends android.app.Application {
    private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
        context= this;
        FontOverride.SetFont("fonts/christmas.ttf");
    }

    public static Context getContext(){
        return context;
    }
}
