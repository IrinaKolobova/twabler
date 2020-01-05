package com.nltweets.twabler.utils;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.nltweets.twabler.R;
import com.nltweets.twabler.activities.LabelingActivity;


public class ExternalOnClickListenerTag implements View.OnClickListener  {
    private LabelingActivity main;
    private boolean isLabelSelected;
    private TextView tag;
    private TextView textView_submission;

    public ExternalOnClickListenerTag(LabelingActivity main, TextView tag){
        super();
        this.main = main;
        this.tag = tag;
        this.textView_submission = textView_submission;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        isLabelSelected = main.getIsLabelSelected();

        if (isLabelSelected) {

            tag.setBackground(main.getSelectedLabel().getBackground());
            tag.setTextAppearance(main, R.style.TagSelected);

            //add +add button and it's implementation


            Log.i("map", "key: " + String.valueOf(main.getSelectedLabel()) + "new value:" + String.valueOf(tag));
            Toast toast= Toast.makeText(main,"map   key: " + String.valueOf(main.getSelectedLabel()) + "new value:" + String.valueOf(tag),Toast.LENGTH_SHORT);

        }
    }

    private boolean setTextViewToButton(){
        textView_submission.setBackground(main.getResources().getDrawable(R.drawable.button_add));
        textView_submission.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        return true;
    }
}
