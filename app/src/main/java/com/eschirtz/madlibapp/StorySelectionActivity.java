package com.eschirtz.madlibapp;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class StorySelectionActivity extends AppCompatActivity {

    // The title to be passed to the template constructor in the Game activity
    private String title;
    // The story, in MadLib markup, to be passed to the constructor
    private String template;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_selection);

        // Populates the list view with all available story
        // the user may choose from
        ArrayList<MadLibItem> stories = new ArrayList<MadLibItem>();
        stories.add(new MadLibItem(StoryDataBase.titleMoon, "Get on your space suit!", StoryDataBase.templateMoon, R.drawable.moon));
        stories.add(new MadLibItem(StoryDataBase.titleCooking, "What's momma cookin up?", StoryDataBase.templateCooking, R.drawable.cooking));
        stories.add(new MadLibItem(StoryDataBase.titlePark, "Any other day...", StoryDataBase.templatePark, R.drawable.park));
        stories.add(new MadLibItem(StoryDataBase.titleLizard, StoryDataBase.subTitleLizard, StoryDataBase.templateLizard, R.drawable.lizard));
        stories.add(new MadLibItem(StoryDataBase.titleCooking, "What's momma cookin up?", StoryDataBase.templateCooking, R.drawable.mountains));
        stories.add(new MadLibItem(StoryDataBase.titlePark, "Any other day...", StoryDataBase.templatePark, R.drawable.cliff));


        MadLibItemAdapter madLibItemAdapter = new MadLibItemAdapter(this, stories);
        ListView listView = (ListView)findViewById(R.id.list);
        listView.setAdapter(madLibItemAdapter);
        ListClickListener listClickListener = new ListClickListener();
        listView.setOnItemClickListener(listClickListener);

        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView txtView = (TextView)findViewById(R.id.myTitle);
        txtView.setText("select a story");

    }
    /**
     *  Starts game
     */
    public void startGame(View view){
        // Send the two necessary strings for the MadLib
        title = StoryDataBase.titleMoon;
        template = StoryDataBase.templateMoon;

        //Intent intent = new Intent(this, Game.class);
        Intent intent = new Intent(this, StorySelectionActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("template", template);
        startActivity(intent);
        this.overridePendingTransition(0, 0);
    }
}
