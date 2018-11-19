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

        Intent intent = getIntent();
        Story story = (Story) intent.getSerializableExtra("Story");
        TextView fullText = findViewById(R.id.storyTxt);
        String fullStory = story.toString();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            fullText.setText(Html.fromHtml(fullStory, Html.FROM_HTML_MODE_COMPACT));
        } else {
            fullText.setText(Html.fromHtml(fullStory));
        }
    }

    public void onButtonClickNewStory(View view) {
        Intent intent = new Intent(FullStory.this, MainActivity.class);
        startActivity(intent);
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(FullStory.this, MainActivity.class);
        startActivity(intent);
    }
}
