package com.example.kitadaharuka.hangman;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ToggleButton;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private ArrayList<Word> words;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        words = new WordList().getWords();
        Collections.shuffle(words);

        ArrayList<Word> arr = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            arr.add(words.get(i));
            Log.d("MainActivity", "list: " + words.get(i).getWord());
        }

        ToggleButton tb = (ToggleButton) findViewById(R.id.play);
        tb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplication(), PlayGameActivity.class);
                startActivity(intent);
            }
        });
    }
}