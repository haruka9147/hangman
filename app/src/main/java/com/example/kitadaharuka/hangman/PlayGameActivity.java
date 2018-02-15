package com.example.kitadaharuka.hangman;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.Point;
import android.graphics.SweepGradient;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.ViewGroup.LayoutParams;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Collections;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class PlayGameActivity extends AppCompatActivity implements View.OnClickListener {
    private final String TAG = "PlayGameActivity";
    private ArrayList<Word> words;
    private ArrayList<Word> quiz;
    private LinearLayout textArea;
    private ArrayList<TextView> textViews;
    private ArrayList<Button> buttons;
    private GridLayout gridLayout;
    private int game_count = 0;
    private int miss_count = 0;
    private int score = 0;
    private int heart_num = 3;
    private ArrayList<ClipAnimationImageView> clipAnimationImageViews;
    private TextView scoreText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_game);

        Intent intent = getIntent();

        words = new WordList().getWords();
        shuffleArray();

        // set invisible
        clipAnimationImageViews = new ArrayList<>();
        clipAnimationImageViews.add((ClipAnimationImageView) findViewById(R.id.image1));
        clipAnimationImageViews.add((ClipAnimationImageView) findViewById(R.id.image2));
        clipAnimationImageViews.add((ClipAnimationImageView) findViewById(R.id.image3));
        clipAnimationImageViews.add((ClipAnimationImageView) findViewById(R.id.image4));
        clipAnimationImageViews.add((ClipAnimationImageView) findViewById(R.id.image5));
        clipAnimationImageViews.add((ClipAnimationImageView) findViewById(R.id.image6));
        clipAnimationImageViews.add((ClipAnimationImageView) findViewById(R.id.image7));
        clipAnimationImageViews.add((ClipAnimationImageView) findViewById(R.id.image8));
        clipAnimationImageViews.add((ClipAnimationImageView) findViewById(R.id.image9));
        clipAnimationImageViews.add((ClipAnimationImageView) findViewById(R.id.image10));

        imageInvisible();

        // set TextView
        textArea = (LinearLayout) findViewById(R.id.textArea);
        setTextViews(quiz.get(game_count).getWord());

        // set click event
        gridLayout = (GridLayout) findViewById(R.id.alphabet_area);
        for(int i = 0; i < gridLayout.getChildCount(); i++) {
            gridLayout.getChildAt(i).setOnClickListener(this);
        }

        // score
        scoreText = (TextView) findViewById(R.id.score);
    }

    /**
     * word array list shuffle
     * @return ArrayList
     */
    private ArrayList<Word> shuffleArray() {
        Collections.shuffle(words);
        quiz = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            quiz.add(words.get(i));
            Log.d(TAG, "word: " + words.get(i).getWord());
        }
        return quiz;
    }

    /**
     * hangman image set invisible
     */
    private void imageInvisible() {
        for(int i = 0; i < clipAnimationImageViews.size(); i++) {
            clipAnimationImageViews.get(i).setVisibility(View.INVISIBLE);
        }
    }


    /**
     * set textView
     * @param word
     */
    private void setTextViews(String word) {
        textArea.removeAllViews();
        textViews = new ArrayList<>();

        for(int i = 0; i < word.length(); i++) {
            TextView textView = new TextView(this);
            textView.setGravity(View.TEXT_ALIGNMENT_CENTER);
            textView.setTextSize(25f);
            textView.setTextColor(Color.WHITE);
            textView.setPadding(10,10,10,10);

            textView.setBackgroundResource(R.drawable.border_bottom);
            textView.setWidth(65);

            // set margin
            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
            lp.setMargins(0, 0 ,20, 0);
            textView.setLayoutParams(lp);
            textArea.addView(textView);

            textViews.add(textView);
        }
    }

    /**
     * check word complete
     * @return boolean
     */
    private boolean isFinished() {
        for(int i = 0; i < textViews.size(); i++) {
            if(textViews.get(i).getText().equals("")) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void onClick(View view) {
        boolean isCorrect = false;
        Button btn = (Button) view;
        String str = btn.getText().toString();
        String answer = quiz.get(game_count).getWord();
        for(int i = 0; i < answer.length(); i++) {
            if(String.valueOf(answer.charAt(i)).equals(str)) {
                textViews.get(i).setText(str);
                textViews.get(i).setPadding(10,10,10,10);
                isCorrect = true;
            }
        }

        if(isCorrect) {
            btn.setTextColor(getResources().getColor(R.color.yellow));
            btn.setBackgroundResource(R.drawable.button_round_yellow);
        } else {
            btn.setTextColor(getResources().getColor(R.color.red));
            btn.setBackgroundResource(R.drawable.button_round_red);
            hangmanImage(miss_count);
            //Log.d(TAG, "miss:" + miss_count);
            miss_count++;
        }

        btn.setEnabled(false);

        // check the word
        if(miss_count == 10) {
            showDialog(false, answer);
        } else if(isFinished()) {
            score++;
            game_count++;
            setTextViews(quiz.get(game_count).getWord());
            scoreText.setText(String.valueOf(score));
            for(int i = 0; i < gridLayout.getChildCount(); i++) {
                Button b = (Button) gridLayout.getChildAt(i);
                b.setEnabled(true);
                b.setTextColor(Color.WHITE);
                b.setBackgroundResource(R.drawable.button_round);
            }
            imageInvisible();
            resetCount();
            showDialog(true, null);
        }
    }

    /**
     * show hangman image
     * @param miss
     */
    private void hangmanImage(int miss) {
        switch (miss) {
            case 0:
                clipAnimationImageViews.get(miss).show(new LeftToRightClipAnimation());
                break;
            case 2:
                clipAnimationImageViews.get(miss).show(new LeftToRightClipAnimation());
                break;
            default:
                clipAnimationImageViews.get(miss).show(new TopToBottomClipAnimation());

        }
    }

    /**
     * show dialog
     * @param result
     * @param answer
     */
    private void showDialog(boolean result, String answer) {
        if(result) {
            new SweetAlertDialog(this, SweetAlertDialog.SUCCESS_TYPE)
                    .setTitleText("You win!")
                    .show();
        } else {
            new SweetAlertDialog(this, SweetAlertDialog.ERROR_TYPE)
                    .setTitleText("You lose...")
                    .setContentText("Answer: " + answer)
                    .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                        @Override
                        public void onClick(SweetAlertDialog sDialog) {
                            game_count++;
                            setTextViews(quiz.get(game_count).getWord());
                            for(int i = 0; i < gridLayout.getChildCount(); i++) {
                                Button b = (Button) gridLayout.getChildAt(i);
                                b.setEnabled(true);
                                b.setTextColor(Color.WHITE);
                                b.setBackgroundResource(R.drawable.button_round);
                            }
                            imageInvisible();
                            resetCount();
                            sDialog.dismissWithAnimation();
                        }
                    })
                    .show();
        }
    }

    private void resetCount() {
        miss_count = 0;
    }


}
