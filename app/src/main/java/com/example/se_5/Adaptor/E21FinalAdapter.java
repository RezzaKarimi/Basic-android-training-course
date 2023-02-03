package com.example.se_5.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.se_5.R;
import com.example.se_5.app.Application;
import com.example.se_5.interfaces.E21FinalOnclick;

public class E21FinalAdapter extends RecyclerView.Adapter<E21FinalAdapter.ViewHolder> {

    String[] items;
    int[] colors;
    E21FinalOnclick listener;

    public E21FinalAdapter(String[] items , int[] colors , E21FinalOnclick onclick){
        this.items   = items;
        this.colors  = colors;
        this.listener = onclick;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(Application.getContext()).inflate(R.layout.layout_e21_row , parent , false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        String name = items[position].split("_")[1];
        String fist = name.substring(0,1);
        holder.title.setText(name);
        holder.first.setText(fist);
        holder.first.setTextColor(Application.getContext().getResources().getColor(colors[position]));
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView first , title;
        RelativeLayout relative;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            first    = itemView.findViewById(R.id.first);
            title    = itemView.findViewById(R.id.title);
            relative = itemView.findViewById(R.id.relative);

            relative.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

           listener.onclick(items[getAdapterPosition()]);
        }
    }
}
