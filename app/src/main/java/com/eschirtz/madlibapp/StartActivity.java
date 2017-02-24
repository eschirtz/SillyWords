package com.eschirtz.madlibapp;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This class serves as the logic for the homepage/landing page for
 * the application. Currently only has a start button. Could eventually implement social
 * functions, creation options
 */
public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);


        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        TextView txtView = (TextView)findViewById(R.id.myTitle);
        txtView.setText(getTitle().toString().toLowerCase());
    }

    /**
     *  The "Start" button will take the user from the landing page
     *  to the Story Selection activity.
     */
    public void chooseStory(View view){
        Intent intent = new Intent(this, StorySelectionActivity.class);
        startActivity(intent);
    }
}
