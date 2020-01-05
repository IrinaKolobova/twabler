package com.nltweets.twabler.utils;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.nltweets.twabler.R;
import com.nltweets.twabler.activities.LabelingActivity;

import java.util.Map;

public class ExternalOnClickListenerLabels implements View.OnClickListener {
    private LabelingActivity main;
    private Button button;
    public Boolean isSelected;
    public Button oldLabel;



    public ExternalOnClickListenerLabels(LabelingActivity main, Button button){
        super();
        this.main = main;
        this.button = button;
    }

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    public void onClick(View v) {
        isSelected = main.getIsLabelSelected();
        oldLabel = main.getSelectedLabel();

        // TODO: fix case where tag clicked before label

        //label selected for the first time
        if(!isSelected){
            selectLabel(button);

        //same label clicked - deselect label
        } else if(oldLabel.equals(button)) {
            deselectLabel(button);

        //another label was selected
        } else {
            deselectLabel(oldLabel);
            selectLabel(button);
            Log.i("Selected label" , "New label was selected" );
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void selectLabel(Button button){

        //button_login.setBackground(main.getDrawable(R.drawable.label_selected));
        button.setTextAppearance(main, R.style.LabelSelected);
        main.setIsLabelSelected(true);
        main.setSelectedLabel(button);
        Log.i("Selected label" , "Label was selected" );
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    private void deselectLabel(Button button){
        button.setTextAppearance(main, R.style.LabelDeselected);
        main.setIsLabelSelected(false);
        main.setSelectedLabel(null);
        Log.i("Selected label" , "Label was deselected" );
    }

    private void createMap(Map<Boolean, Button> selectedLabel) {
        selectedLabel.put(isSelected, button);
    }
}
