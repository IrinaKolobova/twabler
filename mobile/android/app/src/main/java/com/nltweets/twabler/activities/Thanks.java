package com.nltweets.twabler.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nltweets.twabler.R;

public class Thanks extends AppCompatActivity {

    private TextView textView_thanks, textView_appDescription;
    private Button button_instructions, button_startLabeling;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.thanks);

        textView_thanks = findViewById(R.id.textView_thanks);
        textView_appDescription = findViewById(R.id.textView_appDescription);
        button_instructions = findViewById(R.id.button_instructions);
        button_startLabeling = findViewById(R.id.button_startLabeling);

        Toolbar toolbar = findViewById(R.id.toolbar);

    }



    public void instructions(View view) {
    }

    public void startLabeling(View view) {
        Intent intent = new Intent(getApplicationContext(), LabelingActivity.class);
        startActivity(intent);
    }
}
