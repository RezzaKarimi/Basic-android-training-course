package com.example.se_5.Episodes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatCheckBox;
import androidx.appcompat.widget.AppCompatEditText;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;

import com.example.se_5.Objects.E17Dialog_object;
import com.example.se_5.R;
import com.example.se_5.app.app;
import com.example.se_5.interfaces.E17DialogListener;
import com.example.se_5.views.E17_Dialog;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class E17_CustomAlertDialog extends AppCompatActivity implements E17DialogListener {

    AppCompatEditText title , message, color , positive , negative, neutral;
    AppCompatCheckBox positiveCB , negativeCB, neutralCB , dismissCB ,inputCB;
    FloatingActionButton fab;
    E17_Dialog dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e17__custom_alert_dialog);
        setTitle(this.getClass().getSimpleName());
        init();
    }




    private void init() {

        title      = findViewById(R.id.title);
        message    = findViewById(R.id.message);
        color      = findViewById(R.id.color);
        positive   = findViewById(R.id.positive);
        negative   = findViewById(R.id.negative);
        neutral    = findViewById(R.id.neutral);

        positiveCB = findViewById(R.id.positiveCB);
        negativeCB = findViewById(R.id.negativeCB);
        neutralCB  = findViewById(R.id.neutralCB);
        dismissCB  = findViewById(R.id.dismissCB);
        inputCB    = findViewById(R.id.inputCB);

        fab        = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                generateDialog();
            }
        });
    }

    private void generateDialog() {
        String titleString    = title.getText()   .toString().equals("") ? "Title"    : title   .getText().toString();
        String messageString  = message.getText() .toString().equals("") ? "Message"  : message .getText().toString();
        String colorString    = color.getText()   .toString().equals("") ? "Color"    : color   .getText().toString();
        String positiveString = positive.getText().toString().equals("") ? "Positive" : positive.getText().toString();
        String negativeString = negative.getText().toString().equals("") ? "Negative" : negative.getText().toString();
        String neutralString  = neutral.getText() .toString().equals("") ? "Neutral"  : neutral .getText().toString();

        E17Dialog_object object = new E17Dialog_object()
                .setTitle(titleString)
                .setMessage(messageString)
                .setColor(colorString)
                .setPositive(positiveString)
                .setNegative(negativeString)
                .setNeutral(neutralString)
                .setPositive_boolean(positiveCB.isChecked())
                .setNegative_boolean(negativeCB.isChecked())
                .setNeutral_boolean(neutralCB.isChecked())
                .setDismiss_boolean(dismissCB.isChecked())
                .setInput_boolean(inputCB.isChecked())
                .setTitleIcon(R.drawable.ic_baseline_arrow_back_24)
                .setPositiveIcon(R.drawable.ic_baseline_account_circle_24)
                .setNegativeIcon(R.drawable.icon_contacts)
                .setNeutralIcon(R.drawable.ic_baseline_done_24)
                .setTitleColor(R.color.colorPrimary)
                .setPositiveColor(R.color.colorAccent)
                .setNegativeColor(R.color.colorPrimaryDark)
                .setNeutralColor(R.color.design_default_color_background)
                .setListener(this);

        dialog = new E17_Dialog(this, object);
        dialog.show();
        dialog.setCancelable(dismissCB.isChecked());
    }


    @Override
    public void onPositive(String input) {
        dialog.cancel();
        app.t("Positive: "+ input);
    }

    @Override
    public void onNegative(String input) {
        dialog.cancel();
        app.t("Negative: "+ input);
    }

    @Override
    public void onNeutral(String input) {
        dialog.cancel();
        app.t("Neutral: "+ input);
    }

    @Override
    public void Dismiss(String input) {
        dialog.cancel();
        app.t("Dismiss: "+ input);
    }
}