package com.example.danielmunden.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class Level_1_Lesson_2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_1_lesson_2);

        // Get the Intent that started this activity and extract the string
        Intent intent_1_2 = getIntent();
        String message = intent_1_2.getStringExtra(MainActivity.EXTRA_MESSAGE);

        // Capture the layout's TextView and set the string as its text
        TextView textView = findViewById(R.id.textView1);
        textView.setText(message);


    }
}
