package com.madlibs.tom.tom_madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ChooseStory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_choose_story);
    }

    public void onButtonClickStorySelected(View view) {
        Button b = (Button) view;
        String txt = b.getText().toString();
        InputStream is;

        if (txt.equals("Random")) {
            List<String> list = new ArrayList<String>();
            list.add("Simple");
            list.add("Tarzan");
            list.add("University");
            list.add("Clothes");
            list.add("Dance");
            txt = list.get(new Random().nextInt(list.size()));
        }
        switch (txt) {
            case "Simple":
                is = getResources().openRawResource(R.raw.madlib0_simple);
                break;
            case "Tarzan":
                is = getResources().openRawResource(R.raw.madlib1_tarzan);
                break;
            case "University" :
                is = getResources().openRawResource(R.raw.madlib2_university);
                break;
            case "Clothes" :
                is = getResources().openRawResource(R.raw.madlib3_clothes);
                break;
            case "Dance":
                is = getResources().openRawResource(R.raw.madlib4_dance);
                break;
            default:
                is = getResources().openRawResource(R.raw.madlib0_simple);
                break;
        }
        Story story = new Story(is);
        Intent intent = new Intent(ChooseStory.this, StoryFiller.class);
        intent.putExtra("Story", story);
        startActivity(intent);

    }
}
