package com.madlibs.tom.tom_madlibs;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.TextView;

public class FullStory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_story);
        setTitle("MadLibs");

        // Get Story object from intent
        Intent intent = getIntent();
        Story story = (Story) intent.getSerializableExtra("Story");

        // Set textView to correct text, use html tags to make filled in words bold.
        TextView fullText = findViewById(R.id.storyTxt);
        String fullStory = story.toString();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            fullText.setText(Html.fromHtml(fullStory, Html.FROM_HTML_MODE_COMPACT));
        } else {
            fullText.setText(Html.fromHtml(fullStory));
        }
    }

    // return to main activity/ make a new story
    public void onButtonClickNewStory(View view) {
        Intent intent = new Intent(FullStory.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    // Override the back button so you can't change any words after you've seen the whole story
    public void onBackPressed() {
        Intent intent = new Intent(FullStory.this, MainActivity.class);
        startActivity(intent);
    }
}
