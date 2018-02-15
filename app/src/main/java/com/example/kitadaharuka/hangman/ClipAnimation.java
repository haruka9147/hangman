package com.example.kitadaharuka.hangman;

import android.graphics.Path;

/**
 * Created by kitadaharuka on 2018/02/14.
 */

public interface ClipAnimation {
    Path createPath(float progress, int width, int height);
}
