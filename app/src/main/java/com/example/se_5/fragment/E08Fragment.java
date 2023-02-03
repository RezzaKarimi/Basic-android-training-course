package com.example.se_5.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.se_5.Adaptor.E08Chat_page_Adapter;
import com.example.se_5.Objects.E08ChatPage_object;
import com.example.se_5.R;
import com.example.se_5.interfaces.E08EmojiChangeListener;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import io.github.rockerhieu.emojicon.EmojiconEditText;
import io.github.rockerhieu.emojicon.emoji.Emojicon;

public class E08Fragment extends Fragment implements View.OnClickListener {

    public static E08EmojiChangeListener e08EmojiChangeListener;


    AppCompatImageView send , back, emojicon;
    AppCompatTextView profile, no_message;
    EmojiconEditText editText;
    RecyclerView recyclerView;
    E08Chat_page_Adapter e08adapter;
    Boolean me = true;
    Boolean seen = false;
    List<E08ChatPage_object> list = new ArrayList<>();
    public static LinearLayout emoji_Linear;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view    = inflater.inflate(R.layout.layout_e08_fragment, container, false);
        send         = view.findViewById(R.id.send);
        emojicon     = view.findViewById(R.id.emoji);
        back         = view.findViewById(R.id.back);
        profile      = view.findViewById(R.id.profile);
        no_message   =view.findViewById(R.id.no_message);
        editText     = view.findViewById(R.id.editText);
        recyclerView = view.findViewById(R.id.recyclerView);
        emoji_Linear = view.findViewById(R.id.emoji_Linear);
        e08adapter   = new E08Chat_page_Adapter(list);

        recyclerView.setAdapter(e08adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        back.setOnClickListener(this);
        send.setOnClickListener(this);
        emojicon.setOnClickListener(this);

        e08EmojiChangeListener = new E08EmojiChangeListener() {
            @Override
            public void onEmoji(Emojicon emojicon) {

                editText.append(emojicon.getEmoji());
            }

            @Override
            public void onEmojiRemove(View view) {
                String text= editText.getText().toString();
                if (text.length()>2){
                    editText.setText(text.substring(0 , text.length()-2));
                }

            }

            @Override
            public void close() {
               openEmoji();
            }
        };

        return view;
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.back: getActivity().finish(); break;
            case R.id.send: sendMessage(); break;
            case R.id.emoji: openEmoji(); break;
        }
    }

    private void openEmoji() {
        int visibility = emoji_Linear.getVisibility();
        if (visibility == View.GONE){
            emoji_Linear.setVisibility(View.VISIBLE);
            emoji_Linear.startAnimation(AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_in));
        }
        else {
            Animation anim = AnimationUtils.loadAnimation(getActivity(), android.R.anim.fade_out);
            emoji_Linear.startAnimation(anim);
            anim.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {

                    emoji_Linear.setVisibility(View.GONE);
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
        }
    }

    private void sendMessage() {

        me   = !me;
        seen = !seen;
        if (editText.getText().toString().equals("")){
            return;
        }

        Calendar c = Calendar.getInstance();
        String time = c.get(Calendar.HOUR)+":"+c.get(Calendar.MINUTE)+":"+c.get(Calendar.SECOND);
        //time = c.getTime().toString();



        no_message.setVisibility(View.GONE);
        E08ChatPage_object object = new E08ChatPage_object();
        object.setMessage(editText.getText().toString());
        object.setDate(time);
        object.setSeen(seen);
        object.setType(E08ChatPage_object.TYPE_MESSAGE);
        object.setMe(me);

        list.add(object);
        e08adapter.notifyDataSetChanged();
        recyclerView.smoothScrollToPosition(list.size());
        editText.setText("");
    }

}
