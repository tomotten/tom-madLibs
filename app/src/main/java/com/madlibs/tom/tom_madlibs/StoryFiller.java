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
        Intent intent = getIntent();
        story = (Story) intent.getSerializableExtra("Story");
        if (! story.isFilledIn()) {
            String placeHolder = story.getNextPlaceholder();
            // set placeholder of next word.
            TextView placeHolderTxt = findViewById(R.id.placeholderTxt);
            placeHolderTxt.setText("Please type a/an " + placeHolder);

            // set amount of words left
            int count = story.getPlaceholderRemainingCount();
            TextView wordsLeft = findViewById(R.id.wordsLeft);
            String txt = Integer.toString(count) + " Word(s) left!";
            wordsLeft.setText(txt);
        }
        else {
            Intent intent2 = new Intent(StoryFiller.this, FullStory.class);
            intent2.putExtra("Story", story);
            startActivity(intent2);
        }

    }

    public void onButtonClickNext(View view) {
        EditText input = findViewById(R.id.inputWord);
        String word = input.getText().toString();
        story.fillInPlaceholder(word);
        Intent intent = new Intent(StoryFiller.this, StoryFiller.class);
        intent.putExtra("Story", story);
        startActivity(intent);
    }

}
