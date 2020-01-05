package com.nltweets.twabler.utils;

import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.nltweets.twabler.R;
import com.nltweets.twabler.utils.MyPatterns;

import java.util.regex.Pattern;

public class LoginValidationHelper implements View.OnClickListener{

    @Override
    public void onClick(View v) {

    }

    // call this method when you need to check email validation
    public static boolean isEmailAddress(EditText editText, boolean required, String error_message) {
        return isValid(editText, Patterns.EMAIL_ADDRESS, error_message, required);
    }

    // call this method when you need to check phone number validation
    public static boolean isPhoneNumber(EditText editText, boolean required, String error_message) {
        return isValid(editText, Patterns.PHONE, error_message, required);
    }

    // call this method when you need to check name validation
    public static boolean isName(EditText editText, boolean required,String error_message) {
        return isValid(editText, MyPatterns.NAME, error_message, required);
    }

    // call this method when you need to check password validation
    public static boolean isPassword(EditText editText, boolean required, String error_message) {
        return isValid(editText, MyPatterns.PASSWORD, error_message, required);
    }

    // call this method when you need to check date validation
    public static boolean isDate(EditText editText, boolean required, String error_message) {
        return isValid(editText, MyPatterns.DATE, error_message, required);
    }

    // return true if the input field is valid, based on the parameter passed
    public static boolean isValid(EditText editText, Pattern regex, String errMsg, boolean notEmpty) {

        String text = editText.getText().toString().trim();
        // clearing the error, if it was previously set by some other values
        editText.setError(null);

        // text required and
        if (notEmpty) {
            //editText is blank, so return false
            if (!hasText(editText)) {
                return false;
            }

            // pattern doesn't match so returning false
            if (!Pattern.matches(String.valueOf(regex), text)) {
                editText.setError(errMsg);
                return false;
            }
        }

        return true;
    }

    // check the input field has any text or not
    // return true if it contains text otherwise false
    public static boolean hasText(EditText editText) {

        String text = editText.getText().toString().trim();
        editText.setError(null);

        // length 0 means there is no text
        if (text.length() == 0) {
            editText.setError(String.valueOf(R.string.required_error));
            return false;
        }

        return true;
    }


/*
    @Override
    public void onClick(View v) {
        inputValidation(editText_firstName);
        inputValidation(editText_lastName);
        inputValidation(editText_email);
        inputValidation(editText_dateOfBirth);
    }

    private void inputValidation(EditText editText) {
        String editTextInput = editText.getText().toString().trim();
        editText.setError(null);
        if (editText.equals(editText_firstName) || editText.equals(editText_lastName)) {
            if (!NAME.matcher(editTextInput).matches()) {
                editText.setError("Please enter a valid name");
                turnOffSubmitButton();
            } else {
                editText.setError(null);
                ifFieldEmptyCheck();
            }
        }
        if (editText.equals(editText_email)) {
            if (!Patterns.EMAIL_ADDRESS.matcher(editTextInput).matches()) {
                editText.setError("Please enter a valid email");
                turnOffSubmitButton();
            } else {
                editText.setError(null);
                ifFieldEmptyCheck();
            }
        }
        if (editText.equals(editText_dateOfBirth)) {
            if (!DATE_OF_BIRTH.matcher(editTextInput).matches()) {
                editText_dateOfBirth.setError("Please enter a valid date mm/dd/yyyy");
                turnOffSubmitButton();
            } else {
                editText.setError(null);
                ifFieldEmptyCheck();
            }
        }
    }*/
}
