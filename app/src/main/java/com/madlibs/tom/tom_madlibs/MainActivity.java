package com.madlibs.tom.tom_madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


        public void onButtonClick(View view) {

            InputStream is = getResources().openRawResource(R.raw.madlib0_simple);
            Story story = new Story(is);

            Intent intent = new Intent(MainActivity.this, StoryFiller.class);
            intent.putExtra("Story", story);
            startActivity(intent);
        }
}
