package com.sandy.sandtracker.Activities.Tools;

import android.graphics.Color;

import com.sandy.sandtracker.R;

import java.util.Random;

public class SandyColorizer {
    private Random random;

    public SandyColorizer() {
        random = new Random();
    }
    private int[] colors={R.color.color1, R.color.color2,R.color.color3,R.color.color4};
   int pickedColor;
    public int putColor(){
        int num = 0;

        num=random.nextInt(4);


        return colors[num];

    }
}
