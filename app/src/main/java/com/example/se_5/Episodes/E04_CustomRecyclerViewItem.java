package com.example.se_5.Episodes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.se_5.Objects.E04object;
import com.example.se_5.R;
import com.facebook.shimmer.ShimmerFrameLayout;

public class E04_CustomRecyclerViewItem extends AppCompatActivity {

    TextView Artist, Name, View, Like, Comment, Date;
    ImageView img;
    ShimmerFrameLayout shimmer;
    LinearLayout parent;
    E04object object;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_e04_object);

        object = (E04object) getIntent().getSerializableExtra("object");
        setTitle(object.getName());

        init();
    }

    private void init() {

        Artist  = findViewById(R.id.SingerName);
        Name    = findViewById(R.id.SongName);
        View    = findViewById(R.id.View);
        Like    = findViewById(R.id.Like);
        Comment = findViewById(R.id.Comment);
        Date    = findViewById(R.id.Date);
        img     = findViewById(R.id.sngImg);
        parent  = findViewById(R.id.parent);
        shimmer = findViewById(R.id.shimmer);
        shimmer.startShimmer();


        Artist.setText(object.getArtist());
        Name.setText(object.getName());

        View.setText(object.getView()+"");
        Like.setText(object.getLike()+"");
        Comment.setText(object.getComment()+"");

        Date.setText(object.getDate());

        img.setImageResource(object.getImg_Id());


    }
}