package com.example.kitadaharuka.hangman;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.support.v7.widget.AppCompatImageView;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by kitadaharuka on 2018/02/14.
 */

public class ClipAnimationImageView extends AppCompatImageView {
    // animation type
    private ClipAnimation clipAnimation;

    // progress for animation
    private float progress = 10f;

    public ClipAnimationImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        canvas.save();
        if (clipAnimation != null) {
            canvas.clipPath(clipAnimation.createPath(progress, getWidth(), getHeight()));
        }
        float py = this.getHeight()/2.0f;
        float px = this.getWidth()/2.0f;
        canvas.rotate(180, px, py);
        super.onDraw(canvas);
        canvas.restore();
    }

    /**
     * getter for ObjectAnimator
     */
    public float getProgress() {
        return progress;
    }

    /**
     * setter for ObjectAnimator
     */
    public void setProgress(float progress) {
        this.progress = progress;
    }

    public void show(ClipAnimation clipAnimation) {

        this.clipAnimation = clipAnimation;

        ObjectAnimator animator = ObjectAnimator.ofFloat(this, "progress", 0, 1f);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
                setVisibility(View.VISIBLE);
            }
        });
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                invalidate();
            }
        });
        animator.start();
    }

    public void hide(ClipAnimation clipAnimation) {

        this.clipAnimation = clipAnimation;

        ObjectAnimator animator = ObjectAnimator.ofFloat(this, "progress", 1f, 0);
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                setVisibility(View.INVISIBLE);
            }
        });
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                invalidate();
            }
        });
        animator.start();
    }
}
