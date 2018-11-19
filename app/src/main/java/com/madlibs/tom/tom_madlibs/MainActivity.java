package com.madlibs.tom.tom_madlibs;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("MadLibs");
    }


        public void onButtonClick(View view) {
            Intent intent = new Intent(MainActivity.this, ChooseStory.class);
            startActivity(intent);
        }
}
