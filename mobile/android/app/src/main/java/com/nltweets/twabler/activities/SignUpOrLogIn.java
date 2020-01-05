package com.nltweets.twabler.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.nltweets.twabler.R;


public class SignUpOrLogIn extends AppCompatActivity {

    private TextView textView_welcome, textView_description;
    private Button button_signUp, button_logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signup_or_logn);

        textView_welcome = findViewById(R.id.textView_welcome);
        textView_description = findViewById(R.id.textView_description);
        button_signUp = findViewById(R.id.button_signUp);
        button_logIn = findViewById(R.id.button_lIn);

    }

    public void signUp(View view) {

    }

    public void logIn(View view) {
        Intent intent = new Intent(getApplicationContext(), Login.class);
        startActivity(intent);
    }

}
