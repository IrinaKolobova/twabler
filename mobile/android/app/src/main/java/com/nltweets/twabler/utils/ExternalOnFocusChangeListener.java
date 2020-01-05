package com.nltweets.twabler.utils;

import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;
import android.widget.EditText;

import com.nltweets.twabler.R;
import com.nltweets.twabler.activities.Login;

public class ExternalOnFocusChangeListener implements View.OnFocusChangeListener {
    private Login mLogin;
    EditText editText;

    public ExternalOnFocusChangeListener(Login login, EditText editText) {
        super();
        this.mLogin = login;
        this.editText = editText;
    }

    @Override
    public void onFocusChange(View v, boolean hasFocus) {

        if(hasFocus){
            //mLogin.unfocusFields();
            editText.setTextColor(mLogin.getResources().getColor(R.color.colorFocusedText));

        } else {
            if (mLogin.validate(editText)) {
                mLogin.enableSubmitButton();
            } else {
                mLogin.turnOffSubmitButton();
            }
        }

    };
}
