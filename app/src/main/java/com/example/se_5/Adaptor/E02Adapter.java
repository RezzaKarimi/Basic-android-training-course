package com.example.se_5.Adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.se_5.Objects.E02object;
import com.example.se_5.R;
import com.example.se_5.app.Application;

import java.util.List;

public class E02Adapter extends ArrayAdapter<E02object> {

    List<E02object> objects;

    public E02Adapter(@NonNull Context context, int resource, @NonNull List<E02object> objects) {
        super(context, resource, objects);
        this.objects= objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) Application.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view               = inflater.inflate(R.layout.layout_e02_object, parent, false);
        TextView name           = view.findViewById(R.id.name);
        ImageView img           = view.findViewById(R.id.image);
        TextView description    = view.findViewById(R.id.description);

        name.setText(objects.get(position).getName());
        img.setImageResource(objects.get(position).getImg());
        description.setText(objects.get(position).getDescription());



        return view;
    }
}
