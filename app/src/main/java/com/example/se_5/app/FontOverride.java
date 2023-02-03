package com.example.se_5.app;

import android.graphics.Typeface;

import java.lang.reflect.Field;

public class FontOverride {

    public static void SetFont(String Font){
        Typeface typeface = Typeface.createFromAsset(Application.getContext().getAssets() , Font);
        try {

            final Field staticField = Typeface.class.getDeclaredField("MONOSPACE");
            staticField.setAccessible(true);
            staticField.set(null , typeface);

        }catch (Exception e){

        }
    }

}
