package com.example.se_5.Episodes;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Typeface;
import android.os.Bundle;
import android.widget.TextView;

import com.example.se_5.R;

public class E18_CustomFonts extends AppCompatActivity {

    TextView none, black, bunny,charlotte, christmas, envelope, fabulous, locust, micky, monospace, sans, serif;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_e18__custom_fonts);
        setTitle(this.getClass().getSimpleName());
        init();
    }

    private void init() {

        none      = findViewById(R.id.none);
        black     = findViewById(R.id.black);
        bunny     = findViewById(R.id.bunny);
        charlotte = findViewById(R.id.charlotte);
        christmas = findViewById(R.id.christmas);
        envelope  = findViewById(R.id.envelope);
        fabulous  = findViewById(R.id.fabulous);
        locust    = findViewById(R.id.locust);
        micky     = findViewById(R.id.micky);
        monospace = findViewById(R.id.monospace);
        sans      = findViewById(R.id.sans);
        serif     = findViewById(R.id.serif);

        none.append(getString(R.string.none));
        black.append(getString(R.string.black));
        bunny.append(getString(R.string.bunny));
        charlotte.append(getString(R.string.charlotte));
        christmas.append(getString(R.string.christmas));
        envelope.append(getString(R.string.envelope));
        fabulous.append(getString(R.string.fabulous));
        locust.append(getString(R.string.locust));
        micky.append(getString(R.string.micky));
        monospace.append(getString(R.string.monospace));
        sans.append(getString(R.string.sans));
        serif.append(getString(R.string.serif));

        Typeface blackFont = Typeface.createFromAsset(getAssets(),"fonts/black.ttf");
        black.setTypeface(blackFont);

        Typeface bunnyFont = Typeface.createFromAsset(getAssets(),"fonts/bunny.ttf");
        bunny.setTypeface(bunnyFont);

        Typeface charlotteFont = Typeface.createFromAsset(getAssets(),"fonts/charlotte.ttf");
        charlotte.setTypeface(charlotteFont);

        Typeface christmasFont = Typeface.createFromAsset(getAssets(),"fonts/christmas.ttf");
        christmas.setTypeface(christmasFont);

        Typeface envelopeFont = Typeface.createFromAsset(getAssets(),"fonts/envelope.ttf");
        envelope.setTypeface(envelopeFont);

        Typeface fabulousFont = Typeface.createFromAsset(getAssets(),"fonts/fabulous.ttf");
        fabulous.setTypeface(fabulousFont);

        Typeface locustFont = Typeface.createFromAsset(getAssets(),"fonts/locust.ttf");
        locust.setTypeface(locustFont);

        Typeface mickyFont = Typeface.createFromAsset(getAssets(),"fonts/micky.ttf");
        micky.setTypeface(mickyFont);

    }
}