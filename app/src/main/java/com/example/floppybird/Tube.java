package com.example.floppybird;

import java.util.Random;

public class Tube {
    private int tubeX;
    private int topTubeOffsetY;
    private Random mRandom;

    public Tube(int tubeX, int topTubeOffsetY) {
        this.tubeX = tubeX;
        this.topTubeOffsetY = topTubeOffsetY;
        mRandom = new Random();
    }

    public int getTubeX() {
        return tubeX;
    }

    public int getTopTubeOffsetY() {
        return topTubeOffsetY;
    }

    public int getTopTubeY(){
        return topTubeOffsetY - AppConstants.getBitmapBank().getTubeHeight();
    }

    public int getBottomTubeY(){
        return topTubeOffsetY + AppConstants.gapBetweenTopAndBottomTubes;
    }

    public void setTubeX(int tubeX) {
        this.tubeX = tubeX;
    }

    public void setTopTubeOffsetY(int topTubeOffsetY) {
        this.topTubeOffsetY = topTubeOffsetY;
    }
}
