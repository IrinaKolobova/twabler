package com.nltweets.twabler.utils;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.nltweets.twabler.activities.LabelingActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CreateLabelHashMap {

    private LabelingActivity main;
    private boolean isLabelSelected;
    private TextView tag;

    public CreateLabelHashMap(LabelingActivity main, TextView tag){
        super();
        this.main = main;
        this.tag = tag;
    }

/* public Map createMapByLabel(){
        Map<String, List<String>> labelMap = new HashMap<>();
        List<String> labeledTagsList = new ArrayList<>();
        String labeledTag = (String) tag.getText();

        labeledTagsList.add(labeledTag);
        labelMap.put(keyLabel, labeledTagsList);

        return labelMap;
    }*/

    @RequiresApi(api = Build.VERSION_CODES.N)
    public void fillMapByLabel() {
        Map<String, List<String>> map = main.getLabelMap();
        String keyLabel = (String) main.getSelectedLabel().getText();

        //check if map with selectedLabel as key exists
        if (map.containsKey(keyLabel)) {
            List<String> tagList = (ArrayList<String>) map.get(keyLabel);
            //check if value of map are null
            if (tagList == null) {
                //create new list of values if so
                tagList = new ArrayList<>();
            }

            //add new value to list of values
            tagList.add(String.valueOf(tag));
            //replace original value with new value
            map.replace(keyLabel, tagList);

            Log.i("map existed", "key: " + String.valueOf(main.getSelectedLabel()) + "new value:" + String.valueOf(tag));
            Toast toast= Toast.makeText(main,"map existed  key: " + String.valueOf(main.getSelectedLabel()) + "new value:" + String.valueOf(tag),Toast.LENGTH_SHORT);

            //if map with selectedLabel as key does not exists
        } else {
            //create new list for values
            List<String> tagList = new ArrayList<>();
            //add selected tag to list
            tagList.add(String.valueOf(tag));
            //create new map
            map.put(keyLabel, tagList);

            Log.i("map created", "key: " + String.valueOf(main.getSelectedLabel()) + "value:" + String.valueOf(tag));

            Toast toast= Toast.makeText(main,"map created  key: " + String.valueOf(main.getSelectedLabel()) + "new value:" + String.valueOf(tag),Toast.LENGTH_SHORT);
        }

    }

}
