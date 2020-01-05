package com.nltweets.twabler.utils;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.nltweets.twabler.R;
import com.nltweets.twabler.activities.LabelingActivity;

public class SubmissionLimbo {
    private LabelingActivity main;
    private boolean isLabelSelected;
    private TextView tag;

    public SubmissionLimbo(LabelingActivity main, TextView tag){
        super();
        this.main = main;
        this.tag = tag;
    }


    public void showWordsForSubmission(View v) {
        isLabelSelected = main.getIsLabelSelected();

        if (isLabelSelected) {

            tag.setBackground(main.getSelectedLabel().getBackground());
            tag.setTextAppearance(main, R.style.TagSelected);



        }
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void addWordsToHashMap(View v) {


        CreateLabelHashMap clhm = new CreateLabelHashMap(main, tag);
        clhm.fillMapByLabel();

        Log.i("map", "key: " + String.valueOf(main.getSelectedLabel()) + "new value:" + String.valueOf(tag));
        Toast toast = Toast.makeText(main, "map   key: " + String.valueOf(main.getSelectedLabel()) + "new value:" + String.valueOf(tag), Toast.LENGTH_SHORT);
    }


}
