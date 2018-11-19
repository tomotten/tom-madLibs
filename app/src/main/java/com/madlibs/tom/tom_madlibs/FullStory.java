package com.madlibs.tom.tom_madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class FullStory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_story);

        Intent intent = getIntent();
        Story story = (Story) intent.getSerializableExtra("Story");
        TextView fullText = findViewById(R.id.storyTxt);
        fullText.setText(story.toString());
    }
}
