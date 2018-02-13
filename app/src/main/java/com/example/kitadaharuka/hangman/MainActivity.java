package com.example.kitadaharuka.hangman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

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

    }
}
