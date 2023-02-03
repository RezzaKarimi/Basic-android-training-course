package com.example.se_5.Adaptor;


import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.recyclerview.widget.RecyclerView;

import com.example.se_5.Objects.E08ChatPage_object;
import com.example.se_5.R;
import com.example.se_5.app.Application;

import java.util.List;

import io.github.rockerhieu.emojicon.EmojiconTextView;

public class E08Chat_page_Adapter extends RecyclerView.Adapter<E08Chat_page_Adapter.ChatPageViewHolder> {

    List<E08ChatPage_object> object;
    public E08Chat_page_Adapter(List<E08ChatPage_object> object){

        this.object = object;
    }

    @NonNull
    @Override
    public ChatPageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(Application.getContext()).inflate(R.layout.layout_e08_chatpage_row_me , parent , false);
        return new ChatPageViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChatPageViewHolder holder, int position) {

        holder.message.setText(object.get(position).getMessage());
        holder.date.setText(object.get(position).getDate());
        if (!object.get(position).getSeen())
            holder.seen.setVisibility(View.GONE);
        else holder.seen.setVisibility(View.VISIBLE);

        if (object.get(position).getMe()){
            holder.message.setBackgroundResource(R.drawable.layout_bg_him);
        }
        else {
            holder.message.setBackgroundResource(R.drawable.layout_bg_me);
        }

    }

    @Override
    public int getItemCount() {
        return object.size();
    }

    public class ChatPageViewHolder extends RecyclerView.ViewHolder {

        EmojiconTextView message;
        TextView date;
        AppCompatImageView seen;

        public ChatPageViewHolder(@NonNull View itemView) {
            super(itemView);

            message = itemView.findViewById(R.id.message);
            date    = itemView.findViewById(R.id.date);
            seen    = itemView.findViewById(R.id.seen_ic);
        }
    }
}
