package com.example.se_5.Adaptor;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.se_5.Episodes.E04_CustomRecyclerView;
import com.example.se_5.Objects.E04object;
import com.example.se_5.R;
import com.example.se_5.app.Application;
import com.example.se_5.interfaces.E04clickListener;
import com.facebook.shimmer.Shimmer;
import com.facebook.shimmer.ShimmerFrameLayout;

import java.util.List;

public class E04Adapter extends RecyclerView.Adapter<E04Adapter.MyViewHolder> {

    List<E04object> objects;
    E04clickListener clickListener;
    int layoutManagerStyle = E04_CustomRecyclerView.layout_Manager_Linear;

    public E04Adapter(List<E04object> list, E04clickListener itemClickListener , int layoutManagerStyle){
        this.objects= list;
        this.clickListener= itemClickListener;
        this.layoutManagerStyle = layoutManagerStyle;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(Application.getContext()).inflate(
                (layoutManagerStyle==E04_CustomRecyclerView.layout_Manager_Linear)?R.layout.layout_e04_object : R.layout.layout_e04_object_grid,
                parent, false);


        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        E04object object = objects.get(position);

        holder.Artist.setText(object.getArtist());
        holder.Name.setText(object.getName());

        holder.View.setText(object.getView()+"");
        holder.Like.setText(object.getLike()+"");
        holder.Comment.setText(object.getComment()+"");

        holder.Date.setText(object.getDate());

        holder.img.setImageResource(object.getImg_Id());

    }

    @Override
    public int getItemCount() {
        return objects.size();
    }



    public  class MyViewHolder extends RecyclerView.ViewHolder implements android.view.View.OnClickListener {

        TextView Artist, Name, View, Like, Comment, Date;
        ImageView img;
        ShimmerFrameLayout shimmer;
        LinearLayout parent;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            Artist  = itemView.findViewById(R.id.SingerName);
            Name    = itemView.findViewById(R.id.SongName);
            View    = itemView.findViewById(R.id.View);
            Like    = itemView.findViewById(R.id.Like);
            Comment = itemView.findViewById(R.id.Comment);
            Date    = itemView.findViewById(R.id.Date);
            img     = itemView.findViewById(R.id.sngImg);
            parent  = itemView.findViewById(R.id.parent);
            shimmer= itemView.findViewById(R.id.shimmer);
            shimmer.startShimmer();

            parent.setOnClickListener(this);
        }

        @Override
        public void onClick(android.view.View v) {
            clickListener.clickListener(objects.get(getAdapterPosition()));
        }
    }
}



