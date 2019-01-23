package com.example.danielmunden.myapplication;

import android.content.Intent;
import android.speech.tts.TextToSpeech;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Locale;

public class Level_1_Lesson_1 extends AppCompatActivity {

    String text1;
    EditText et;
    TextToSpeech tts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_level_1_lesson_1);

        // Get the text input by ID
        et = findViewById(R.id.editText1);

        // Create a TextToSpeech object, implement an OnInitListener to convert the text to speech
        tts = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if(status == TextToSpeech.SUCCESS){
                    Locale turkLocale = new Locale("tr", "TR");
                    int result=tts.setLanguage(turkLocale);
                    if(result==TextToSpeech.LANG_MISSING_DATA ||
                            result==TextToSpeech.LANG_NOT_SUPPORTED){
                        Log.e("error", "This Language is not supported");
                    }
                }
                else
                    Log.e("error", "Initialization Failed!");
            }
        });
    }

    // If the app is closed or "paused", stop the text to speech
    @Override
    protected void onPause() {
        if(tts != null){
            tts.stop();
            tts.shutdown();
        }
        super.onPause();
    }

    public void onClick12(View v){
        ConvertTextToSpeech();
    }

    public void hideText1(View view) {
        TextView txtView = findViewById(R.id.content1);
        //Toggle
        if (txtView.getVisibility() == View.VISIBLE)
            txtView.setVisibility(View.INVISIBLE);
        else
            txtView.setVisibility(View.VISIBLE);
    }

    private void ConvertTextToSpeech() {
        // TODO Auto-generated method stub
        text1 = et.getText().toString();
        if(text1==null||"".equals(text1))
        {
            text1 = "Content not available";
            tts.speak(text1,TextToSpeech.QUEUE_FLUSH,null,null);
        }else
            tts.setSpeechRate(0.75f);
            tts.speak(text1+" Pelin. Siktir git!",TextToSpeech.QUEUE_FLUSH,null,null);
    }
}
