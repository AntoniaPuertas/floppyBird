package com.example.floppybird;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {

    Bitmap background_game;

    public BitmapBank(Resources resources){
        background_game = BitmapFactory.decodeResource(resources, R.drawable.background_game);
    }

    public Bitmap getBackground_game() {
        return background_game;
    }

    public int getBackgroundWidth(){
        return background_game.getWidth();
    }

    public int getBackgroundHeight(){
        return background_game.getHeight();
    }
}
