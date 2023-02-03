package com.example.se_5.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.se_5.Episodes.E10_Contacts;
import com.example.se_5.Objects.E10object;
import com.example.se_5.R;
import com.example.se_5.app.Application;

import java.util.List;

public class E10Adapter extends RecyclerView.Adapter<E10Adapter.ViewHolder> {


    List<E10object> object;

    public E10Adapter(List<E10object> object){
        this.object = object;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(Application.getContext()).inflate(R.layout.layout_e10_row , parent , false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.name.setText(object.get(position).getName());
        holder.tel.setText(object.get(position).getTel());
    }

    @Override
    public int getItemCount() {
        return object.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        ImageView img;
        TextView name , tel;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            img  = itemView.findViewById(R.id.img);
            name = itemView.findViewById(R.id.name);
            tel  = itemView.findViewById(R.id.tel);
        }
    }
}
