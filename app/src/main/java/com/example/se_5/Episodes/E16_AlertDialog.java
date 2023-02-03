package com.example.se_5.Episodes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;

import com.example.se_5.R;
import com.example.se_5.app.app;

public class E16_AlertDialog extends AppCompatActivity implements View.OnClickListener {

    EditText title , message , positive , negative , neutral;
    CheckBox posCB , negCB , neutCB, inpCB;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e16__alert_dialog);
        setTitle(getClass().getSimpleName());
        init();
    }

    private void init() {

        title   = findViewById(R.id.title);
        message = findViewById(R.id.message);
        positive= findViewById(R.id.positive);
        negative= findViewById(R.id.negative);
        neutral = findViewById(R.id.neutral);
        posCB   = findViewById(R.id.positiveCB);
        negCB   = findViewById(R.id.negativeCB);
        neutCB  = findViewById(R.id.neutralCB);
        inpCB   = findViewById(R.id.input);
        button  = findViewById(R.id.button);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        generateDialog();
    }




    private void generateDialog(){
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        final EditText editText = new EditText(this);
        alertDialog.setTitle(title.getText().toString().equals("")?"Title":title.getText().toString());
        alertDialog.setMessage(message.getText().toString().equals("")?"Message":message.getText().toString());
        if (posCB.isChecked()){

            alertDialog.setPositiveButton(positive.getText().toString().equals("")?"Positive":positive.getText().toString(), new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    app.t("Your device is optimized"+ (editText.getText().toString().equals("")?"":"\n"+ editText.getText().toString()));
                }
            });
        }
        if (negCB.isChecked()){

            alertDialog.setNegativeButton(negative.getText().toString().equals("")?"Negative":negative.getText().toString() , null);
        }

        if (neutCB.isChecked()){

            alertDialog.setNeutralButton(neutral.getText().toString().equals("")?"neutral":neutral.getText().toString() , null);
        }

        if (inpCB.isChecked()){
            alertDialog.setView(editText);
        }
;
        alertDialog.show();
    }
}