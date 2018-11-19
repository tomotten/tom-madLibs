package com.madlibs.tom.tom_madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class StoryFiller extends AppCompatActivity {
    Story story;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_story_filler);
        setTitle("MadLibs");

        // Get chosen Story object from intent
        Intent intent = getIntent();
        story = (Story) intent.getSerializableExtra("Story");

        // Let user fill in all placeholders till story complete
        if (! story.isFilledIn()) {
            String placeHolder = story.getNextPlaceholder();
            TextView placeHolderTxt = findViewById(R.id.placeholderTxt);
            placeHolderTxt.setText("Please type a/an " + placeHolder);

            // show amount of words left
            int count = story.getPlaceholderRemainingCount();
            TextView wordsLeft = findViewById(R.id.wordsLeft);
            String txt = Integer.toString(count) + " Word(s) left!";
            wordsLeft.setText(txt);
        }
        // if all words are filled in direct the user to activity for the full Story (pass story via intent)
        else {
            Intent intent2 = new Intent(StoryFiller.this, FullStory.class);
            intent2.putExtra("Story", story);
            startActivity(intent2);
        }
    }

    // if clicked on the continue button get user input and add to story, than pass story to new storyFiller activity via intent.
    public void onButtonClickNext(View view) {
        EditText input = findViewById(R.id.inputWord);
        String word = input.getText().toString();
        story.fillInPlaceholder(word);
        Intent intent = new Intent(StoryFiller.this, StoryFiller.class);
        intent.putExtra("Story", story);
        startActivity(intent);
    }

}
