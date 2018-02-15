package com.example.kitadaharuka.hangman;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

public class PlayGameActivity extends AppCompatActivity implements View.OnClickListener {
    private final String TAG = "PlayGameActivity";
    private ArrayList<Word> words;
    private ArrayList<Word> quiz;
    private LinearLayout textArea;
    private ArrayList<TextView> textViews;
    private ArrayList<Button> buttons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        Intent intent = getIntent();

        words = new WordList().getWords();
        shuffleArray();

        // set TextView
        textArea = (LinearLayout) findViewById(R.id.textArea);
        setTextViews(quiz.get(1).getWord());

        // set click event
//        buttons.add((Button) findViewById(R.id.button1));
//        buttons.add((Button) findViewById(R.id.button1));
//        buttons.add((Button) findViewById(R.id.button1));
//        buttons.add((Button) findViewById(R.id.button1));
//        buttons.add((Button) findViewById(R.id.button1));
//        buttons.add((Button) findViewById(R.id.button1));
//        buttons.add((Button) findViewById(R.id.button1));
//        buttons.add((Button) findViewById(R.id.button1));
//        buttons.add((Button) findViewById(R.id.button1));
//        buttons.add((Button) findViewById(R.id.button1));
//        buttons.add((Button) findViewById(R.id.button1));
//        buttons.add((Button) findViewById(R.id.button1));
//        buttons.add((Button) findViewById(R.id.button1));
//        buttons.add((Button) findViewById(R.id.button1));
//        buttons.add((Button) findViewById(R.id.button1));
//        buttons.add((Button) findViewById(R.id.button1));
//        buttons.add((Button) findViewById(R.id.button1));
//        buttons.add((Button) findViewById(R.id.button1));
//        buttons.add((Button) findViewById(R.id.button1));


    }

    private ArrayList<Word> shuffleArray() {
        Collections.shuffle(words);
        quiz = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            quiz.add(words.get(i));
        }
        return quiz;
    }

    private void setTextViews(String word) {
        textViews = new ArrayList<>();

        for(int i = 0; i < word.length(); i++) {
            TextView textView = new TextView(this);
            textView.setTextSize(28f);
            textView.setTextColor(Color.WHITE);
            textView.setPadding(10,10,10,10);

            textView.setBackgroundResource(R.drawable.border_bottom);
            textView.setWidth(60);

            // set margin
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(0, 0 ,20, 0);
            textView.setLayoutParams(lp);
            textArea.addView(textView);

            textViews.add(textView);
        }
    }

    @Override
    public void onClick(View view) {

    }
}
