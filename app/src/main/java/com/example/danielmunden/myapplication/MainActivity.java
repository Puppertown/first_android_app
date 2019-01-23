package com.example.danielmunden.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    public static final String EXTRA_MESSAGE = "com.example.danielmunden.MESSAGE";

    // Create boolean arrays for the button sets
    boolean[] level_1_booleans = new boolean[3];
    boolean[] level_2_booleans = new boolean[2];

    // Initialize button arrays
    ImageButton[] level_1_buttons;
    ImageButton[] level_2_buttons;

    // Initialize button drawable arrays
    int[] imgIds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Set the layout to the main xml file
        setContentView(R.layout.activity_main);

        // Pre-select "learn" for the bottom navigation view
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setSelectedItemId(R.id.action_learn);

        // Initialize level 1 buttons
        ImageButton button_lv1_1 = findViewById(R.id.imgBut_1_1);
        button_lv1_1.setOnClickListener(this); // calling onClick() method
        ImageButton button_lv1_2 = findViewById(R.id.imgBut_1_2);
        button_lv1_2.setOnClickListener(this);
        ImageButton button_lv1_3 = findViewById(R.id.imgBut_1_3);
        button_lv1_3.setOnClickListener(this);

        // Initialize level 2 buttons, disable them
        ImageButton button_lv2_1 = findViewById(R.id.imgBut_2_1);
        button_lv2_1.setOnClickListener(this);
        button_lv2_1.setEnabled(false);
        ImageButton button_lv2_2 = findViewById(R.id.imgBut_2_2);
        button_lv2_2.setOnClickListener(this);
        button_lv2_2.setEnabled(false);

        // Put level buttons into an array
        level_1_buttons = new ImageButton[] {button_lv1_1,button_lv1_2,button_lv1_3};
        level_2_buttons = new ImageButton[]{button_lv2_1,button_lv2_2};

        // Create an array of drawable references for level 2
        imgIds = new int[] {R.drawable.ic_arm_up,R.drawable.ic_forum_black_24dp};





    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.imgBut_1_1:
                view.setBackgroundResource(R.drawable.rounded_background_filled);
                this.level_1_booleans[0] = true;

                Intent intent_1_1 = new Intent(this, Level_1_Lesson_1.class);
                String message_1_1 = "This is Level 1, Lesson 1";
                intent_1_1.putExtra(EXTRA_MESSAGE, message_1_1);
                startActivity(intent_1_1);

                if (areAllTrue(this.level_1_booleans)) unlockNextLevel(2);

                break;

            case R.id.imgBut_1_2:
                view.setBackgroundResource(R.drawable.rounded_background_filled);
                this.level_1_booleans[1] = true;

                Intent intent_1_2 = new Intent(this, Level_1_Lesson_2.class);
                String message_1_2 = "This is Level 1, Lesson 2";
                intent_1_2.putExtra(EXTRA_MESSAGE, message_1_2);
                startActivity(intent_1_2);

                if (areAllTrue(this.level_1_booleans)) unlockNextLevel(2);
                break;

            case R.id.imgBut_1_3:
                view.setBackgroundResource(R.drawable.rounded_background_filled);
                this.level_1_booleans[2] = true;

                Intent intent_1_3 = new Intent(this, Level_1_Lesson_3.class);
                String message_1_3 = "This is Level 1, Lesson 3";
                intent_1_3.putExtra(EXTRA_MESSAGE, message_1_3);
                startActivity(intent_1_3);

                if (areAllTrue(this.level_1_booleans)) unlockNextLevel(2);
                break;

            case R.id.imgBut_2_1:

                if (view.isEnabled()) {
                    view.setBackgroundResource(R.drawable.rounded_background_filled);
                    this.level_2_booleans[0] = true;

                    Intent intent_2_1 = new Intent(this, Level_2_Lesson_1.class);
                    String message_2_1 = "This is Level 2, Lesson 1";
                    intent_2_1.putExtra(EXTRA_MESSAGE, message_2_1);
                    startActivity(intent_2_1);

                    break;
                }

            case R.id.imgBut_2_2:

                if (view.isEnabled()) {
                    view.setBackgroundResource(R.drawable.rounded_background_filled);
                    this.level_2_booleans[1] = true;

                    Intent intent_2_2 = new Intent(this, Level_2_Lesson_2.class);
                    String message_2_2 = "This is Level 2, Lesson 2";
                    intent_2_2.putExtra(EXTRA_MESSAGE, message_2_2);
                    startActivity(intent_2_2);

                    break;
                }

                break;

            default:
                break;
        }
    }

    public void unlockNextLevel(int level){
        // Will need to use multi-dimensional arrays
        for (int i = 0; i < this.level_1_buttons.length; i++) {
            this.level_1_buttons[i].setBackgroundResource(R.drawable.rounded_background_complete);
        }
        for (int i = 0; i < this.level_2_buttons.length; i++) {
            this.level_2_buttons[i].setEnabled(true);
            this.level_2_buttons[i].setImageResource(this.imgIds[i]);
            this.level_2_buttons[i].setScaleType(ImageView.ScaleType.FIT_XY);
            this.level_2_buttons[i].setBackgroundResource(R.drawable.rounded_background);
        }
    }

    public static boolean areAllTrue(boolean[] array) {
        for(boolean b : array) if(!b) return false;
        return true;
    }


}