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

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private TextView textView_tweetToTag;
    private Button button_skip, button_submit, button_label1, button_label2, button_label3, button_label4;
    private DrawerLayout drawer;
    private FlexboxLayout tagLayout, labelsLayout;

    int numberOfWords;
    ArrayList<String> twitText = new ArrayList<>();

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
        addWords();
        addTextViews();


    }

    public void addWords(){
        //hardcoded! in the future get words from json
        twitText.add("Lorem");
        twitText.add("ipsum");
        twitText.add("dolor");
        twitText.add("sit");
        twitText.add("amet");
        twitText.add("consectetur");
        twitText.add("adipiscing");
        twitText.add("elit");
        twitText.add("sed");

        numberOfWords = twitText.size();
    }

    //test version (just to make dynamic text views work)
    public void addTextViews(){

        final TextView[] tagTextViews = new TextView[numberOfWords];
        for (int i = 0; i < numberOfWords; i++) {
            final TextView wordTextView = new TextView(this);
            wordTextView.setLayoutParams(new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, 45));
            wordTextView.setGravity(Gravity.CENTER_VERTICAL);
            wordTextView.setPadding(0, 0, 20, 0);
            wordTextView.setText(twitText.get(i));
            tagLayout.addView(wordTextView);
            tagTextViews[i] = wordTextView;
            //TextView text = (TextView) activity.findViewById(R.id.text);
            //text.setClickable(true)
            wordTextView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    wordTextView.setBackgroundColor(getResources().getColor(R.color.label1));
                }
            });
        }
    }

    @Override
    public void onBackPressed(){
        if(drawer.isDrawerOpen(GravityCompat.START)){
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public void label1(View view){
        button_label1.setBackground(getDrawable(R.drawable.button_selected));
    }

    public void label2(View view){

    }

    public void label3(View view){

    }

    public void label4(View view){

    }

    public void skip(View view) {
    }

    public void submit(View view) {
    }

    public void close_menu(View view) {
        drawer.closeDrawers();
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
