package com.example.se_5.Adaptor;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.se_5.Objects.E01object;
import com.example.se_5.R;
import com.example.se_5.app.Application;

import java.util.List;


public class E01Adapter extends ArrayAdapter<E01object>{


    List<E01object> list;
    private final int MODE_GetView  =0;
    private final int MODE_DropDown =1;


    public E01Adapter(@NonNull Context context, int resource, @NonNull List<E01object> objects) {
        super(context, resource, objects);
        this.list= objects;
    }



    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        return createView(position, convertView, parent, MODE_GetView);
    }

    @Override
    public View getDropDownView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {


        return createView(position, convertView, parent, MODE_DropDown);
    }






    private View createView(int position, @Nullable View convertView, @NonNull ViewGroup parent , int mode){
        LayoutInflater inflater= (LayoutInflater) Application.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view= inflater.inflate(R.layout.layout_e01_object, parent, false);

        TextView name= view.findViewById(R.id.name);
        ImageView img= view.findViewById(R.id.e01_img);

        name.setText(list.get(position).getName());
        img.setImageResource(list.get(position).getDrawable());


        if (mode==MODE_DropDown){
            name.setTextColor(Color.BLACK);
        }

        return view;
    }

}