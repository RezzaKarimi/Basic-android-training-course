package com.example.se_5.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.se_5.R;
import com.example.se_5.app.Application;
import com.example.se_5.interfaces.E13ClickListener;

import java.util.List;

public class E13Adapter extends RecyclerView.Adapter<E13Adapter.ViewHolder> {


    List<int[]> items;
    public static E13ClickListener listener;

    public E13Adapter(List<int[]> items){
        this.items = items;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(Application.getContext()).inflate(R.layout.layout_e13_row, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        holder.icon.setImageResource(items.get(position)[0]);
        holder.text_icon.setText(items.get(position)[1]);
    }

    @Override
    public int getItemCount() {
        return items.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        AppCompatImageView icon;
        TextView text_icon;
        RelativeLayout relativeLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            icon           = itemView.findViewById(R.id.icon);
            text_icon      = itemView.findViewById(R.id.text_icon);
            relativeLayout = itemView.findViewById(R.id.relative);
            relativeLayout.setOnClickListener(this);

        }

        @Override
        public void onClick(View v) {
            if (listener !=null)
                listener.onclick(items.get(getAdapterPosition()));
        }
    }




}
