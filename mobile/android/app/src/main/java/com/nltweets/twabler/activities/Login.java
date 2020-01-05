package com.nltweets.twabler.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.nltweets.twabler.utils.ExternalListenerOnTextChange;
import com.nltweets.twabler.utils.LoginValidationHelper;
import com.nltweets.twabler.R;

public class Login extends AppCompatActivity {

    private View layout_loginPage;
    private ImageView imageView_logoSmall;
    private TextView textView_welcomeLogin;
    private EditText editText_email;
    private Button button_submit;
    private boolean et_e;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        et_e = false;

        layout_loginPage = findViewById(R.id.layout_loginPage);
        imageView_logoSmall = findViewById(R.id.logo_small);
        textView_welcomeLogin = findViewById(R.id.textView_welcomeLogin);
        editText_email = findViewById(R.id.editText_email);
        button_submit = findViewById(R.id.button_logIn);

        turnOffSubmitButton();

        editText_email.addTextChangedListener(new ExternalListenerOnTextChange(this, editText_email));
        //editText_email.setOnFocusChangeListener(new ExternalOnFocusChangeListener(this, editText_email));
    }


    public boolean validate(EditText editText) {
        boolean isValid = false;

        if (editText.equals(editText_email)) {
            isValid = LoginValidationHelper.isEmailAddress(editText_email, true, getResources().getString(R.string.email_error));
        }
        return isValid;
    }

    public void enableSubmitButton(){
            button_submit.setEnabled(true);
            button_submit.setBackground(getResources().getDrawable(R.drawable.button_login));
    }

    public void turnOffSubmitButton(){
        button_submit.setEnabled(false);
        button_submit.setBackground(getResources().getDrawable(R.drawable.button_disabled));
    }

    public void login(View v){
        Intent intentThanks = new Intent(getApplicationContext(), Thanks.class);
        startActivity(intentThanks);
        //disable go back to login activity
        Login.this.finish();
    }



    /*public void unfocusFields(){
        editText_firstName.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        editText_lastName.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        editText_email.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
        editText_dateOfBirth.setTextColor(getResources().getColor(R.color.colorPrimaryDark));
    }*/

}