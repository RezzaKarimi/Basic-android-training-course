package com.example.se_5.Episodes;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.se_5.R;
import com.example.se_5.fragment.E08Fragment;

import io.github.rockerhieu.emojicon.EmojiconGridFragment;
import io.github.rockerhieu.emojicon.EmojiconsFragment;
import io.github.rockerhieu.emojicon.emoji.Emojicon;
import io.github.rockerhieu.emojiconize.Emojiconize;


public class E08_Fragment extends AppCompatActivity implements
        EmojiconsFragment.OnEmojiconBackspaceClickedListener ,
        EmojiconGridFragment.OnEmojiconClickedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Emojiconize.activity(this).go();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e08__fragment);
        setTitle(getClass().getSimpleName());
        init();
    }

    private void init() {

    }

    @Override
    public void onEmojiconClicked(Emojicon emojicon) {

        if (E08Fragment.e08EmojiChangeListener!=null){
            E08Fragment.e08EmojiChangeListener.onEmoji(emojicon);
        }
    }

    @Override
    public void onEmojiconBackspaceClicked(View v) {

        E08Fragment.e08EmojiChangeListener.onEmojiRemove(v);
    }

    @Override
    public void onBackPressed() {

        if(E08Fragment.emoji_Linear.getVisibility() == View.VISIBLE)
            E08Fragment.e08EmojiChangeListener.close();
        else  super.onBackPressed();
    }
}