package com.example.se_5.Episodes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.GridView;

import com.example.se_5.Adaptor.E03Adapter;
import com.example.se_5.Objects.E02object;
import com.example.se_5.R;

import java.util.ArrayList;
import java.util.List;

public class E03_CustomGridView extends AppCompatActivity {

    GridView gridView;
    List<E02object> list;
    E03Adapter adapter;
    CheckBox name, image, description;
    EditText columnNum;

    public static Boolean ShowName, ShowImage, ShowDescription = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e03__custom_grid_view);
        setTitle(getClass().getSimpleName());
        init();
    }

    private void init() {
        gridView    = findViewById(R.id.gridView);
        name        = findViewById(R.id.name);
        image       = findViewById(R.id.image);
        description = findViewById(R.id.description);
        columnNum   = findViewById(R.id.columnNum);

        columnNum.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence txt, int i, int i1, int i2) {
                try {
                    int num = Integer.parseInt(txt.toString());
                    gridView.setNumColumns(num);
                }
                catch (Exception e){

                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });




        checkItems();
        list        = preparedata();
        adapter     = new E03Adapter(this, 0, list);
        gridView.setAdapter(adapter);
    }

    private void checkItems(){
        ShowName        = name.isChecked();
        ShowImage       = image.isChecked();
        ShowDescription = description.isChecked();
    }

    public void onClick(View checkBox){
        checkItems();
        adapter.notifyDataSetChanged();
    }


    private List<E02object> preparedata() {

        List<E02object> list = new ArrayList<>();

        E02object object     = new E02object();
        object.setName(getString(R.string.renegades));
        object.setImg(R.drawable.renegades);
        object.setDescription(getString(R.string.renegades_description));
        list.add(object);

        object               = new E02object();
        object.setName(getString(R.string.jeepers));
        object.setImg(R.drawable.jeepers);
        object.setDescription(getString(R.string.jeepers_description));
        list.add(object);

        object               = new E02object();
        object.setName(getString(R.string.hampstead));
        object.setImg(R.drawable.hampstead);
        object.setDescription(getString(R.string.hampstead_description));
        list.add(object);

        object               = new E02object();
        object.setName(getString(R.string.england));
        object.setImg(R.drawable.england);
        object.setDescription(getString(R.string.england_description));
        list.add(object);

        object               = new E02object();
        object.setName(getString(R.string.snowman));
        object.setImg(R.drawable.snowman);
        object.setDescription(getString(R.string.snowman_description));
        list.add(object);

        object               = new E02object();
        object.setName(getString(R.string.vincent));
        object.setImg(R.drawable.vincent);
        object.setDescription(getString(R.string.vincent_description));
        list.add(object);

        object               = new E02object();
        object.setName(getString(R.string.brawl));
        object.setImg(R.drawable.brawl);
        object.setDescription(getString(R.string.brawl_description));
        list.add(object);

        object               = new E02object();
        object.setName(getString(R.string.bright));
        object.setImg(R.drawable.bright);
        object.setDescription(getString(R.string.bright_description));
        list.add(object);

        object               = new E02object();
        object.setName(getString(R.string.eden));
        object.setImg(R.drawable.eden);
        object.setDescription(getString(R.string.eden_description));
        list.add(object);

        return list;
    }
}