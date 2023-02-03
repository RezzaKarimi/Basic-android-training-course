package com.example.se_5.interfaces;

import android.view.View;

import io.github.rockerhieu.emojicon.emoji.Emojicon;


public interface E08EmojiChangeListener {

    void onEmoji(Emojicon emojicon);
    void onEmojiRemove(View view);
    void close();
}
