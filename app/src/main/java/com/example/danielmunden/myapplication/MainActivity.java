package com.example.danielmunden.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.danielmunden.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_learn);




    }

    /** Called when the user taps the Send button */
    public void button1Click(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String message = "This is a test string";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }



    public void button2Click(View view) {
        Button button1 = findViewById(R.id.button2);
        button1.setBackgroundColor(Color.rgb(226, 11, 11));
    }
}