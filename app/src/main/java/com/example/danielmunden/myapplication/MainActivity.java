package com.example.danielmunden.myapplication;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_MESSAGE = "com.example.danielmunden.MESSAGE";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_learn);

        ImageButton button_lv1_1 = findViewById(R.id.imgBut_1_1);
        button_lv1_1.setOnClickListener(this); // calling onClick() method
        ImageButton button_lv1_2 = findViewById(R.id.imgBut_1_2);
        button_lv1_2.setOnClickListener(this);
        ImageButton button_lv2_1 = findViewById(R.id.imgBut_2_1);
        button_lv2_1.setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.imgBut_1_1:
                view.setBackgroundResource(R.drawable.rounded_background_filled);
                Drawable drawable = ContextCompat.getDrawable(this, R.drawable.ic_gamepad_controller);
                drawable = DrawableCompat.wrap(drawable);
                DrawableCompat.setTint(drawable, ContextCompat.getColor(this,R.color.aqua));

                ImageButton aButton = (ImageButton)view;
                aButton.setImageResource(R.drawable.ic_gamepad_controller);


                break;

            case R.id.imgBut_1_2:
                view.setBackgroundResource(R.drawable.rounded_background_filled);
                break;

            case R.id.imgBut_2_1:
                view.setBackgroundResource(R.drawable.rounded_background_filled);
                break;

            default:
                break;
        }
    }



    /** Called when the user taps the Send button */
    public void button1Click(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        String message = "This is a test string";
        intent.putExtra(EXTRA_MESSAGE, message);
        startActivity(intent);
    }

}