package com.nltweets.twabler.utils;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

import com.nltweets.twabler.R;
import com.nltweets.twabler.activities.Login;

public class ExternalListenerOnTextChange implements TextWatcher {
    private Login mLogin;
    EditText editText;

    public ExternalListenerOnTextChange(Login login, EditText editText) {
        super();
        this.mLogin = login;
        this.editText = editText;
    }

    @Override
    public void afterTextChanged(Editable s) {
        if (mLogin.validate(editText)) {
            mLogin.enableSubmitButton();
        } else {
            mLogin.turnOffSubmitButton();
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        //mLogin.unfocusFields();
        editText.setTextColor(mLogin.getResources().getColor(R.color.colorFocusedText));

        if (mLogin.validate(editText)) {
            mLogin.enableSubmitButton();
        } else {
            mLogin.turnOffSubmitButton();
        }

    }

}