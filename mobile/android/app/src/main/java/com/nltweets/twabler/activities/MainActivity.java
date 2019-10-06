package com.nltweets.twabler.activities;

import android.os.Build;
import android.os.Bundle;
import android.support.annotation.RequiresApi;
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


public class MainActivity extends AppCompatActivity {

    private TextView textView_tweetToTag;
    private Button button_skip, button_submit, button_label1, button_label2, button_label3, button_label4;
    private DrawerLayout drawer;
    private FlexboxLayout tagLayout, labelsLayout;
    public static boolean isLabelSelected = false;
    public static Button selectedLabel;

    int numberOfTwitWords;
    ArrayList<String> twitWords = new ArrayList<>();
    ArrayList<Button> tags = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button_skip = findViewById(R.id.button_skip);
        button_submit = findViewById(R.id.button_submit);
        button_label1 = findViewById(R.id.label1);
        button_label2 = findViewById(R.id.label2);
        button_label3 = findViewById(R.id.label3);
        button_label4 = findViewById(R.id.label4);

        drawer = findViewById(R.id.drawer_layout);
        labelsLayout = (FlexboxLayout) findViewById(R.id.labelsLayout);
        labelsLayout.setFlexDirection(FlexDirection.ROW);
        tagLayout = (FlexboxLayout) findViewById(R.id.tagLayout);
        tagLayout.setFlexDirection(FlexDirection.ROW);

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
        button_label3.setOnClickListener(new ExternalOnClickListenerLabels(this, button_label3));
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
        twitWords.add("Lorem");
        twitWords.add("ipsum");
        twitWords.add("dolor");
        twitWords.add("sit");
        twitWords.add("amet");
        twitWords.add("consectetur");
        twitWords.add("adipiscing");
        twitWords.add("elit");
        twitWords.add("do");
        twitWords.add("eiusmod");
        twitWords.add("tempor");
        twitWords.add("incididunt");
        twitWords.add("ut");
        twitWords.add("labore");
        twitWords.add("et");
        twitWords.add("dolore");
        twitWords.add("magna");
        twitWords.add("aliqua");

        numberOfTwitWords = twitWords.size();
    }

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
        for(String twitWordToTag : twitWords){
            final TextView wordTextView = new TextView(this);
            wordTextView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 45));
            wordTextView.setGravity(Gravity.CENTER_VERTICAL);
            wordTextView.setPadding(0, 0, 20, 0);
            wordTextView.setText(twitWordToTag);
            tagLayout.addView(wordTextView);
            wordTextView.setClickable(true);


        }

    }


    private boolean tag(TextView textView, Button label){

        boolean isTagged = false;
        //textView.setOnClickListener(new ExternalOnClickListenerTag(true, ));

        return isTagged;
    }


    public void skip_tweet(View view) {
    }

    public void submit_tweet(View view) {
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
                Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_instructions:
                Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.action_faq:
                Toast.makeText(MainActivity.this, item.getTitle().toString(), Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    } */
}
