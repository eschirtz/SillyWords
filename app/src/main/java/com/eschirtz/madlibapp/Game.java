package com.eschirtz.madlibapp;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Vibrator;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Layout;
import android.text.method.ScrollingMovementMethod;
import android.view.KeyEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.view.View.OnKeyListener;

import java.util.ArrayList;

import static android.R.attr.max;
import static android.R.attr.width;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.T;
import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

public class Game extends AppCompatActivity {

    // Layout for the Game activity
    private LinearLayout gameLinearLayout;
    // Tracks if game button has been pressed (changes from "build" to "view")
    private boolean gameButtonPressed = false;
    // Game button, multipurpose "Build" and "View"
    private Button gameButton;
    // Next button
    private Button nextButton;
    // Context of app
    private Context context;
    // Edit text object, to be used for reading user input
    private EditText editText;
    // Shows user what words they have entered
    private String enteredWords = "";
    // Story title label
    private TextView titleLabel;
    // Counter message
    private TextView counterMessage;

    // MADLIB FIELDS
    // Holds final story
    private String story = "Something went wrong";
    // Madlib template
    private MadLibTemplate template;
    // Title received from intent
    private String title = "TITLE";
    // templateStory received from intent
    private String templateStory = "Story;END";
    // The story elements from template
    private ArrayList<String> storyElements = new ArrayList<String>();
    // Parts of speech from template
    private ArrayList<String> partsOfSpeech = new ArrayList<String>();
    // User input words
    private ArrayList<String> userWords = new ArrayList<String>();
    // Toast variable
    private Toast toast;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        // Receive data from Intent COPIED CODE
        if (savedInstanceState == null) {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
            } else {
                title = extras.getString("title");
                templateStory = extras.getString("template");
            }
        } else {
            title = (String) savedInstanceState.getSerializable("title");
            templateStory = (String) savedInstanceState.getSerializable("template");
        }
        // Initialize the MadLib fields
        template = new MadLibTemplate(title, templateStory);
        storyElements = template.getStoryElements();
        partsOfSpeech = template.getPartsOfSpeech();
        editText = (EditText) findViewById(R.id.user_input_words);
        editText.setHint("Enter a " + partsOfSpeech.get(0)); // Initializes the prompt

        // Action bar stuff
        getSupportActionBar().setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        getSupportActionBar().setCustomView(R.layout.abs_layout);
        TextView txtView = (TextView)findViewById(R.id.myTitle);
        txtView.setText(title.toLowerCase() + "...");

    }

    /**
     * After NEXT pressed, get's user input, adding to UserWords array list.
     * Ends when array list is full.
     * Updates hint. Displays words already used.
     */
    public void getUserWord(View view) {
        // Fetches info for the edit text view
        editText = (EditText) findViewById(R.id.user_input_words);
        if (editText.getText().toString().equals("")) {
            Toast.makeText(getApplicationContext(), "Enter a word!", Toast.LENGTH_SHORT).show();
            return;
        }

        userWords.add(editText.getText().toString()); // Adds word to userWords
        editText.setText(""); // Clears text
        editText.setHint("Enter a " + partsOfSpeech.get(userWords.size())); // Updates hint
        if (partsOfSpeech.get(userWords.size()).equals("END")) {
            editText.setVisibility(View.GONE);
            nextButton = (Button) findViewById(R.id.next_button);
            nextButton.setVisibility(View.GONE);
            gameButton = (Button) findViewById(R.id.game_button);
            gameButton.setVisibility(View.VISIBLE);

            // CODE COPIED, HIDE KEYBOARD
            InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
        }

        // Updates counter message
        counterMessage = (TextView) findViewById(R.id.word_enter_view);
        int wordsLeft = partsOfSpeech.size() - userWords.size() - 1;
        // Break points for different messages to user
        if (wordsLeft > 5) {
            counterMessage.setText("" + wordsLeft + " words left!");
        } else if (wordsLeft > 1) {
            counterMessage.setText("Only " + wordsLeft + " words to go!");
        } else if (wordsLeft == 1)
            counterMessage.setText(R.string.input_word_message_final);
        else {
            counterMessage.setVisibility(View.GONE);
            ImageView arrow = (ImageView) findViewById(R.id.arrow);
            arrow.setVisibility(View.GONE); // Arrow and message go away. Ready for build
        }

        TextView tempTextView = (TextView) findViewById(R.id.temp_text_view);
        enteredWords = userWords.get(userWords.size() - 1) + "\n" + enteredWords;
        tempTextView.setText(enteredWords);
        tempTextView.setMovementMethod(new ScrollingMovementMethod());
    }

    /**
     * Builds story from story elements and user input values
     */
    public void showStory(View view) {
        story = (new MadLibStory(storyElements, userWords)).getStory();
        toast = Toast.makeText(getApplicationContext(), "Story Built", Toast.LENGTH_SHORT);
        toast.show();
        // Opens the view story activity
        Intent intent = new Intent(this, ViewStory.class);
        intent.putExtra("story", story);
        intent.putExtra("title", title);
        startActivity(intent);
    }
}

