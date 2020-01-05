package com.nltweets.twabler.activities;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

import com.google.android.flexbox.FlexDirection;
import com.google.android.flexbox.FlexboxLayout;
import com.nltweets.twabler.R;
import com.nltweets.twabler.utils.ExternalOnClickListenerLabels;
import com.nltweets.twabler.utils.ExternalOnClickListenerTag;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class LabelingActivity extends AppCompatActivity {

    private TextView textView_tweetToTag, textView_labeling, textView_tweet, textView_submission, textViewToButton_submission;
    private Button button_skipOrSubmit;
    private static Button button_label1;
    private Button button_label2;
    private Button button_label4;
    private DrawerLayout drawer;
    private FlexboxLayout tweetLayout, labelsLayout;
    public static boolean isLabelSelected = false;
    public Button selectedLabel;
    private Map<String, List<String>> labelMap = new HashMap<>();
    private ArrayList<String> labeledTags = new ArrayList<>();

    int numberOfTweetWords;
    ArrayList<String> tweetWords = new ArrayList<>();
    ArrayList<Button> tags = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.labeling);

        textView_labeling = findViewById(R.id.textView_labeling);
        textView_tweet = findViewById(R.id.textView_tweet);
        textView_submission = findViewById(R.id.textView_submission);
        textViewToButton_submission = findViewById(R.id.textViewToButton_submission);

        //button_skip = findViewById(R.id.button_skip);
        button_skipOrSubmit = findViewById(R.id.button_skipOrSubmit);
        button_label1 = findViewById(R.id.label1);
        button_label2 = findViewById(R.id.label2);
        button_label4 = findViewById(R.id.label4);

        setLabelBackgroundColor(button_label1);
        setLabelBackgroundColor(button_label2);
        setLabelBackgroundColor(button_label4);

        drawer = findViewById(R.id.drawer_layout);
        labelsLayout = (FlexboxLayout) findViewById(R.id.labelsLayout);
        labelsLayout.setFlexDirection(FlexDirection.ROW);
        tweetLayout = (FlexboxLayout) findViewById(R.id.tweetLayout);
        tweetLayout.setFlexDirection(FlexDirection.ROW);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowTitleEnabled(false);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        //toggle.getDrawerArrowDrawable().setColor(getResources().getColor(R.color.colorTrueWhite));
        addTags();
        addTextViews();

        button_label1.setOnClickListener(new ExternalOnClickListenerLabels(this, button_label1));
        button_label2.setOnClickListener(new ExternalOnClickListenerLabels(this, button_label2));
        button_label4.setOnClickListener(new ExternalOnClickListenerLabels(this, button_label4));

    }


    @Override
    public void onBackPressed(){
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
        
    }

    public void addTags(){
        //hardcoded! in the future get words from json
        tweetWords.add("@sfmta_muni");
        tweetWords.add("looks");
        tweetWords.add("like");
        tweetWords.add("you");
        tweetWords.add("guys");
        tweetWords.add("need");
        tweetWords.add("to");
        tweetWords.add("fix");
        tweetWords.add("your");
        tweetWords.add("signs");
        tweetWords.add("in");
        tweetWords.add("Embarcadero");
        tweetWords.add("...");
        tweetWords.add("one");
        tweetWords.add("show");
        tweetWords.add("L");
        tweetWords.add("West");
        tweetWords.add("Portal");
        tweetWords.add("other");
        tweetWords.add("shows");
        tweetWords.add("M");

        numberOfTweetWords = tweetWords.size();
    }

    //create lapels dynamically
   /* public void addTags(){
        //hardcoded! in the future get words from json
        tags.add(button_label1);
        tags.add(button_label2);
        tags.add(button_label3);
        tags.add(button_label4);
    }

    public void addButtons(){
        for(Button tag: tags){
            final Button
        }
    }*/

    public void addTextViews(){
        //final TextView[] tagTextViews = new TextView[numberOfWords];
        for(String twitWordToTag : tweetWords){
            final TextView wordTextView = new TextView(this);
            wordTextView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 70));
            wordTextView.setGravity(Gravity.CENTER_VERTICAL);
            wordTextView.setPadding(0, 0, 20, 0);
            wordTextView.setText(twitWordToTag);
            wordTextView.setTextColor(getResources().getColor(R.color.colorBlack));
            wordTextView.setTextSize(20);
            wordTextView.setTypeface(null, Typeface.BOLD);
            tweetLayout.addView(wordTextView);
            wordTextView.setClickable(true);
            wordTextView.setOnClickListener(new ExternalOnClickListenerTag(this, wordTextView));

        }
    }


    private boolean tag(TextView textView, Button label){

        boolean isTagged = false;
        //textView.setOnClickListener(new ExternalOnClickListenerTag(true, ));

        return isTagged;
    }


    public void skip_tweet(View view) {
        this.recreate();
    }

    public void skipOrSubmit_tweet(View view) {
        Intent intent = getIntent();
        finish();
        startActivity(intent);
    }

    public void close_menu(View view) {
        drawer.closeDrawers();
    }

    public Button getSelectedLabel(){
        return selectedLabel;
    }

    public void setSelectedLabel(Button newSelectedLabel){
        this.selectedLabel = newSelectedLabel;
    }

    public boolean getIsLabelSelected(){
        return isLabelSelected;
    }

    public void setIsLabelSelected(boolean isLabelSelected){
        this.isLabelSelected = isLabelSelected;
    }

    public Map<String, List<String>> getLabelMap() {
        return labelMap;
    }


    /*
        @Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.navigation_menu, menu);
            return super.onCreateOptionsMenu(menu);
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();
            switch (id){
                case R.id.action_add_contact:
                    Toast.makeText(LabelingActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.action_instructions:
                    Toast.makeText(LabelingActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                    break;
                case R.id.action_faq:
                    Toast.makeText(LabelingActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                    break;
            }
            return super.onOptionsItemSelected(item);
        } */
    private int getRandomColor(){
        return Color.rgb(rand(0,255), rand(0,255), rand(0,255));
    }

    private int rand(int a, int b) {
        return((int)((b-a+1)*Math.random() + a));
    }



    private void setLabelBackgroundColor(Button button){
        button.setBackgroundColor(getRandomColor());
    }

    private void setTextViewSubmissionToButtonAdd(TextView textView){
        textView.setBackground(getResources().getDrawable(R.drawable.button_add));
        textView.setText(getResources().getText(R.string.button_add));
        textView.setTextColor(getResources().getColor(R.color.colorTrueWhite));
        textView.setTextSize(60);
    }

    private void setButtonAddTextViewSubmission(TextView textView){
        textView.setBackground(getResources().getDrawable(R.drawable.text_box));

        //find the way to set text

        textView.setTextColor(getResources().getColor(R.color.colorBlack));
        textView.setTextSize(20);
    }

    //fillMapByLabel(labelMap, labeledTags);


}
