package com.example.kitadaharuka.hangman;

import android.graphics.Path;

/**
 * Created by kitadaharuka on 2018/02/14.
 */

public class TopToBottomClipAnimation implements ClipAnimation{
    @Override
    public Path createPath(float progress, int width, int height) {
        Path path = new Path();
        path.addRect(0, 0, width, height * progress, Path.Direction.CCW);
        return path;
    }
}
