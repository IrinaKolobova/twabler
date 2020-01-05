package com.nltweets.twabler.utils;

import android.util.Patterns;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MyPatterns {

    /**
     * Regular expression pattern to match password requirements.
     */
    public static final Pattern PASSWORD =
            Pattern.compile("^" +
                    //"(?=.*[0-9])" +         //at least 1 digit
                    //"(?=.*[a-z])" +         //at least 1 lower case letter
                    //"(?=.*[A-Z])" +         //at least 1 upper case letter
                    "(?=.*[a-zA-Z])" +      //any letter
                    "(?=.*[@#$%^&+=])" +    //at least 1 special character
                    "(?=\\S+$)" +           //no white spaces
                    ".{4,}" +               //at least 4 characters
                    "$");

    /**
     * Regular expression pattern to match date.
     */
    public static final Pattern DATE =
            Pattern.compile("^(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\\d\\d$");

    /**
     * Regular expression pattern to match name.
     */
    public static final Pattern NAME = Pattern.compile("^[\\p{L} .'-]+$");

    /**
     * Regular expression pattern to match phone requirements.
     */
    private static final String PHONE_REGEX = "\\d{3}-\\d{7}";

}
