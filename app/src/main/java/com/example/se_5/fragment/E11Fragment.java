package com.example.se_5.fragment;

import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.se_5.Objects.E11object;
import com.example.se_5.R;
import com.example.se_5.app.app;

public class E11Fragment extends Fragment {


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        E11object object = (E11object) getArguments().getSerializable("object");

        View view = inflater.inflate(R.layout.e11_fragment , container , false);
        ImageView img = view.findViewById(R.id.imgResId);

        img.setImageResource(object.getImg_res());

        return view;
    }
}



