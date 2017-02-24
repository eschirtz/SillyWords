package com.eschirtz.madlibapp;

import android.content.Intent;
import android.support.v4.app.NavUtils;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import static android.content.Intent.ACTION_SEND;

public class ViewStory extends AppCompatActivity {
    // Story title
    private String title;
    // Story body text
    private String story;
    // Share message tagline
    private String tagline = "Created in Silly Words, download from the Google Play store today!";
    // Email subject
    private String emailSubject;
    // Title TextView
    private TextView titleTextView;
    // Story TextView
    private TextView storyTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_story);

        // Fetch extra data from intent
        Bundle extras = getIntent().getExtras();
        title = extras.getString("title");
        story = extras.getString("story");
        //titleTextView = (TextView)findViewById(R.id.story_name_view);
        storyTextView = (TextView) findViewById(R.id.story_text_view);
        //titleTextView.setText(title);
        storyTextView.setText(story);

        // Action bar stuff
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        TextView txtView = (TextView) findViewById(R.id.myTitle);
        txtView.setText(title.toLowerCase());
        txtView = (TextView) findViewById(R.id.story_title_textview);
        txtView.setText(title.toLowerCase());
    }
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.game_menu, menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.share_button:
                share();
                break;
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                break;
        }

        return true;
    }


    /**
     * Shares story via email
     * @param view
     */
    public void share(View view){
        String emailBody = title + "...\n\n" + story + "\n\n" + tagline;
        emailSubject = title + " - Silly Words";
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_TEXT, emailBody);
        intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
    /**
     * Shares story via email, constructor for menu button
     *
     */
    public void share(){
        String emailBody = title + "...\n\n" + story + "\n\n" + tagline;
        emailSubject = title + " - Silly Words";
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.setType("*/*");
        intent.putExtra(Intent.EXTRA_TEXT, emailBody);
        intent.putExtra(Intent.EXTRA_SUBJECT, emailSubject);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}
