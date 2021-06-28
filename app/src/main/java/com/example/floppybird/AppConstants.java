package com.example.floppybird;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class AppConstants {

    static BitmapBank sBitmapBank;

    static GameEngine sGameEngine;

    static int SCREEN_WIDTH;
    static int SCREEN_HEIGHT;

    static int gravity;

    static int VELOCITY_WHEN_JUMPED;

    static int gapBetweenTopAndBottomTubes;

    static int numberOfTubes;
    static int tubeVelocity;
    static int minTubeOffsetY;
    static int maxTubeOffsetY;
    static int distanceBetweenTubes;

    public static void initialzation(Context context){
        setScreenSize(context);
        sBitmapBank = new BitmapBank(context.getResources());
        setGameConstants();
        sGameEngine = new GameEngine();
    }

    public static void setGameConstants(){
        AppConstants.gravity = 3;
        AppConstants.VELOCITY_WHEN_JUMPED = -40;
        AppConstants.gapBetweenTopAndBottomTubes = 600;

        AppConstants.numberOfTubes = 2;
        AppConstants.tubeVelocity = 12;
        AppConstants.minTubeOffsetY = (int) (AppConstants.gapBetweenTopAndBottomTubes / 2.0);
        AppConstants.maxTubeOffsetY = AppConstants.SCREEN_HEIGHT - AppConstants.minTubeOffsetY - AppConstants.gapBetweenTopAndBottomTubes;
        AppConstants.distanceBetweenTubes = AppConstants.SCREEN_HEIGHT * 3/4;
    }

    public static BitmapBank getBitmapBank(){
        return sBitmapBank;
    }

    public static GameEngine getGameEngine(){
        return sGameEngine;
    }

    private static void setScreenSize(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;

        AppConstants.SCREEN_WIDTH = width;
        AppConstants.SCREEN_HEIGHT = height;
    }
}
